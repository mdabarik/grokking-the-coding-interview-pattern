import java.util.*;

class File {
    String content;
    public File (String content) {
        this.content = content;
    }
    public void appendContent(String content) {
        this.content = this.content + content;
    }
}

class TrieNode {
    HashMap<String, TrieNode> directories = new HashMap<>();
    HashMap<String, File> files = new HashMap<>();
}

public class FileSystem {
    TrieNode root;
    public FileSystem() {
        root = new TrieNode();
    }
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        String[] paths = path.split("/");
        TrieNode curr = root;
        for (int i = 1; i < paths.length; i++) {
            String dir = paths[i];
            if (curr.directories.containsKey(dir)) {
                curr = curr.directories.get(dir);
            } else { // we are given file path and we found filepath
                result.add(dir);
                return result;
            }
        }
        // get file's name and dir's name and sort it in lexicographic order
        result.addAll(curr.directories.keySet());
        result.addAll(curr.files.keySet());
        Collections.sort(result);
        return result;
    } // TC: O(n * log n), SC: O(n)

    public void mkdir(String path) {
        // "/a/b/c", ["","a","b","c"]
        String[] paths = path.split("/");
        TrieNode curr = root;
        for (int i = 1; i < paths.length; i++) {
            String folder = paths[i];
            if (!curr.directories.containsKey(folder)) {
                curr.directories.put(folder, new TrieNode());
            }
            curr = curr.directories.get(folder);
        }
    } // TC: O(n), SC: O(n)

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        TrieNode curr = root;
        for (int i = 1; i < paths.length-1; i++) {
            curr = curr.directories.get(paths[i]);
        }
        // get the fileName
        String fileName = paths[paths.length-1];
        if (!curr.files.containsKey(fileName)) {
            curr.files.put(fileName, new File(content));
        } else {
            File file = curr.files.get(fileName);
            file.appendContent(content);
        }
    } // TC: O(n), SC: O(n)

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        TrieNode curr = root;
        for (int i = 1; i < paths.length-1; i++) {
            curr = curr.directories.get(paths[i]);
        }
        // get the fileName
        String fileName = paths[paths.length-1];
        return curr.files.get(fileName).content;
    } // TC: O(n), SC: O(n)
}






