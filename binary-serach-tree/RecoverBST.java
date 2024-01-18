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
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode curr = root, prev = null;

        while (curr != null) {
            if (curr.left == null) { // LRootR
                // print curr
                if (prev == null) {
                    prev = curr;
                } else {
                    if (prev.val > curr.val) {
                        if (first == null) {
                            first = prev;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    prev = curr;
                }
                curr = curr.right;
            } else {
                TreeNode rightMostNode = curr.left; // predeccessor
                while (rightMostNode.right != null && rightMostNode.right != curr) {
                    rightMostNode = rightMostNode.right;
                }
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr; // thread
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    // print curr
                    if (prev == null) {
                        prev = curr;
                    } else {
                        if (prev.val > curr.val) {
                            if (first == null) {
                                first = prev;
                                second = curr;
                            } else {
                                second = curr;
                            }
                        }
                        prev = curr;
                    }
                    curr = curr.right;
                }
            }
        }

        // swap first and second
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

// TC: o(n), SC: O(1)