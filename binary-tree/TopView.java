

//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static class Pair {
        Node node;
        int v;
        public Pair (Node node, int v) {
            this.node = node;
            this.v = v;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // left most vertical index and right most vertical index
        int leftMost = Integer.MAX_VALUE, rightMost = Integer.MIN_VALUE;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node currNode = curr.node;
            int v = curr.v;
            leftMost = Math.min(leftMost, v);
            rightMost = Math.max(rightMost, v);
            if (!map.containsKey(v)) {
                map.put(v, currNode.data);
            }
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, v - 1));
            }
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, v + 1));
            }
        }
        ArrayList<Integer> top_view = new ArrayList<>();
        for (int key = leftMost; key <= rightMost; key++) {
            top_view.add(map.get(key));
        }
        return top_view;
    }  // TC: O(n), SC: O(n)
    // static ArrayList<Integer> topView(Node root) {
    //     TreeMap<Integer, Integer> map = new TreeMap<>();
    //     Queue<Pair> queue = new LinkedList<>();
    //     queue.add(new Pair(root, 0));
    //     while (!queue.isEmpty()) {
    //         Pair curr = queue.poll();
    //         Node currNode = curr.node;
    //         int v = curr.v;
    //         if (!map.containsKey(v)) {
    //             map.put(v, currNode.data);
    //         }
    //         if (currNode.left != null) {
    //             queue.add(new Pair(currNode.left, v - 1));
    //         }
    //         if (currNode.right != null) {
    //             queue.add(new Pair(currNode.right, v + 1));
    //         }
    //     }
    //     ArrayList<Integer> top_view = new ArrayList<>();
    //     for (Integer value : map.values()) {
    //         top_view.add(value);
    //     }
    //     return top_view;
    // } 
}// TC: O(n * log n), SC: O(n)
