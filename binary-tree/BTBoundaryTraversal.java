

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution {
	ArrayList<Integer> boundary(Node node) {
	    ArrayList<Integer> traversal = new ArrayList<>();
	    traversal.add(node.data);
	    if (node.left == null && node.right == null) return traversal;
	    // left boundary
	    findLeftBoundary(node.left, traversal);
	    // leaf nodes
	    findLeafNodes(node, traversal);
	    // right boundary
	    findRightBoundary(node.right, traversal);
	    return traversal;
	} // TC: O(n), SC: O(n)
	void findLeftBoundary(Node node, ArrayList<Integer> traversal) { // preorder: RoLR
	    // base case
	    if (node == null) return;
	    if (node.left == null && node.right == null) return;
	    traversal.add(node.data);
	    // recursive case
	    if (node.left != null) {
	        findLeftBoundary(node.left, traversal);
	    } else if (node.right != null) {
	        findLeftBoundary(node.right, traversal);
	    }
	}
	void findLeafNodes(Node node, ArrayList<Integer> traversal) {
	    // base case
	    if (node == null) return;
	    if (node.left == null && node.right == null) {
	        traversal.add(node.data);
	        return;
	    }
	    // recursive case
	    findLeafNodes(node.left, traversal);
	    findLeafNodes(node.right, traversal);
	}
	void findRightBoundary(Node node, ArrayList<Integer> traversal) { // RLRo
	    // base case
	    if (node == null) return;
	    if (node.left == null && node.right == null) return;
	    // recursive case
	    if (node.right != null) {
	        findRightBoundary(node.right, traversal);
	    } else if (node.left != null) {
	        findRightBoundary(node.left, traversal);
	    }
	    traversal.add(node.data);
	}
}
