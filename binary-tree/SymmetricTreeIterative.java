
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode r1 = stack.pop();
            TreeNode r2 = stack.pop();
            if (r1 == null && r2 == null) continue;
            if (r1 == null || r2 == null) return false;
            if (r1.val != r2.val) return false;
            // left, right
            stack.push(r1.left);
            stack.push(r2.right);
            // right, left
            stack.push(r1.right);
            stack.push(r2.left);
        }
        return true;
    }
}
// TC: O(n), SC: O(1)