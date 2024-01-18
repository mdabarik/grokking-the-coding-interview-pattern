/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        // level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode parentNode = queue.poll();
                if (parentNode.left != null) {
                    queue.add(parentNode.left);
                    parent.put(parentNode.left, parentNode);
                }
                if (parentNode.right != null) {
                    queue.add(parentNode.right);
                    parent.put(parentNode.right, parentNode);
                }
            }
        }
        // bfs algorithm to find out all nodes with distance k from target node
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty() && k != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                }
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    queue.add(parent.get(curr));
                }
            }
            k--;
        }
        // extract nodes values from queue to list
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {F
            res.add(queue.poll().val);
        }
        return res;
    }
}

// TC: O(n), SC: O(n)

