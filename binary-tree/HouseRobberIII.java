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
    public int rob(TreeNode root) {
        // [rob, notRob]
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    public int[] dfs(TreeNode root) {
        // base case
        if (root == null) return new int[] {0, 0};
        // recursive case
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, notRob};
    }
}
// TC: O(n), SC: O(h)