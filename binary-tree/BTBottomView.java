

class Solution {
    public class Pair {
        Node node;
        int v;
        public Pair (Node node, int v) {
            this.node = node;
            this.v = v;
        }
    }
    public ArrayList <Integer> bottomView(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftMax = Integer.MAX_VALUE, rightMax = Integer.MIN_VALUE;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node currNode = curr.node;
            int v = curr.v;
            leftMax = Math.min(leftMax, v);
            rightMax = Math.max(rightMax, v);
            map.put(v, currNode.data);
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, v - 1));
            }
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, v + 1));
            }
        }
        ArrayList <Integer> bottom_view = new ArrayList<>();
        for (int key = leftMax; key <= rightMax; key++) {
            bottom_view.add(map.get(key));
        }
        return bottom_view;
    } // TC: O(n), SC: O(n)
    // public ArrayList <Integer> bottomView(Node root) {
    //     TreeMap<Integer, Integer> map = new TreeMap<>();
    //     Queue<Pair> queue = new LinkedList<>();
    //     queue.add(new Pair(root, 0));
    //     while (!queue.isEmpty()) {
    //         Pair curr = queue.poll();
    //         Node currNode = curr.node;
    //         int v = curr.v;
    //         map.put(v, currNode.data);
    //         if (currNode.left != null) {
    //             queue.add(new Pair(currNode.left, v - 1));
    //         }
    //         if (currNode.right != null) {
    //             queue.add(new Pair(currNode.right, v + 1));
    //         }
    //     }
    //     ArrayList <Integer> bottom_view = new ArrayList<>();
    //     for (Integer value : map.values()) {
    //         bottom_view.add(value);
    //     }
    //     return bottom_view;
    // }
}
// TC: O(n * log n), SC: O(n)
