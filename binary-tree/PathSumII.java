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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rootToLeafPaths = new ArrayList<>();
        helper(root, rootToLeafPaths, new ArrayList<>(), targetSum);
        return rootToLeafPaths;
    }
    public void helper(TreeNode root,  List<List<Integer>> rootToLeafPaths, List<Integer> currPath, int targetSum) {
        // base case
        if (root == null) return;
        currPath.add(root.val);
        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            rootToLeafPaths.add(new ArrayList<>(currPath));
        }
        // recursive case
        helper(root.left, rootToLeafPaths, new ArrayList<>(currPath), targetSum - root.val);
        helper(root.right, rootToLeafPaths, new ArrayList<>(currPath), targetSum - root.val);
    }
}

// TC: O(n), SC: O(n)


