import java.util.*;

class TrieNode {
    HashMap<String, TrieNode> children = new HashMap<>();
    int value;
    public TrieNode(int value) {
        this.value = value;
    }
}

class FileSystem {
    TrieNode root;
    public FileSystem() {
        root = new TrieNode(-1);
    }
    
    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        TrieNode curr = root;
        for (int i = 1; i < arr.length-1; i++) {
            String currParent = arr[i];
            if (!curr.children.containsKey(currParent)) return false;
            curr = curr.children.get(currParent);
        }
        String lastItem = arr[arr.length-1];
        if (curr.children.containsKey(lastItem)) return false; // if already exists
        curr.children.put(lastItem, new TrieNode(value));
        return true;
    } // TC: O(k), SC: O(k)
    
    public int get(String path) {
        String[] arr = path.split("/");
        TrieNode curr = root;
        for (int i = 1; i < arr.length; i++) {
            String currDir = arr[i];
            if (!curr.children.containsKey(currDir)) return -1;
            curr = curr.children.get(currDir);
        }
        return curr.value;
    } // TC: O(k), SC: O(1)
}

