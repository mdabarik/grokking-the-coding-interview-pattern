/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, paths, "");
        return paths;
    }
    public void dfs(TreeNode root, List<String> paths, String currPath) {
        // base case
        if (root == null) return;
        // recursive case
        if (root.left == null && root.right == null) { // if root is leaf node
            currPath = currPath + "->" + root.val;
            paths.add(currPath.substring(2));
        }
        dfs(root.left, paths, currPath + "->" + root.val);
        dfs(root.right, paths, currPath + "->" + root.val);
    }
}


// TC: O(n), SC: O(n)