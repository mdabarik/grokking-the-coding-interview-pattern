import java.util.HashMap;
import java.util.Map;

class FileSystem {
    private Map<String, Integer> fileSystem;

    public FileSystem() {
        fileSystem = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (fileSystem.containsKey(path)) {
            return false; // Path already exists
        }

        // Check if the parent path exists
        int lastSlashIndex = path.lastIndexOf('/');
        if (lastSlashIndex > 0) {
            String parentPath = path.substring(0, lastSlashIndex);
            if (!fileSystem.containsKey(parentPath)) {
                return false; // Parent path doesn't exist
            }
        }
        // Add the path to the map
        fileSystem.put(path, value);
        return true;
    } // O(n), O(n)

    public int get(String path) {
        return fileSystem.getOrDefault(path, -1);
    } // O(1), O(1)
}