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
    public class Tuple {
        TreeNode node;
        int v, h;
        public Tuple(TreeNode node, int v, int h) {
            this.node = node;
            this.v = v;
            this.h = h;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            TreeNode currNode = curr.node;
            int v = curr.v, h = curr.h;
            if (!map.containsKey(v)) {
                map.put(v, new TreeMap<>());
            }
            if (!map.get(v).containsKey(h)) {
                map.get(v).put(h, new PriorityQueue<>());
            }
            map.get(v).get(h).add(currNode.val);
            if (currNode.left != null) {
                queue.add(new Tuple(currNode.left, v - 1, h + 1));
            }
            if (currNode.right != null) {
                queue.add(new Tuple(currNode.right, v + 1, h + 1));
            }
        }
        List<List<Integer>> traversal = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> pair : map.values()) {
            traversal.add(new ArrayList<>());
            for (PriorityQueue<Integer> currPQ : pair.values()) {
                while (!currPQ.isEmpty()) {
                    traversal.get(traversal.size() - 1).add(currPQ.poll());
                }
            }
        }
        return traversal;
    }
}
