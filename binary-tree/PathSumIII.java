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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum, 0, map);
    }
    public int dfs(TreeNode root, int targetSum, long pathSum, HashMap<Long, Integer> map) {
        // base case
        if (root == null) return 0;
        // recursive case
        pathSum += root.val;
        int numPath = map.getOrDefault(pathSum - targetSum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        int left = dfs(root.left, targetSum, pathSum, map);
        int right = dfs(root.right, targetSum, pathSum, map);
        numPath += left + right;
        map.put(pathSum, map.get(pathSum) - 1);
        return numPath;
    }
}

// TC: O(n), SC: O(n)