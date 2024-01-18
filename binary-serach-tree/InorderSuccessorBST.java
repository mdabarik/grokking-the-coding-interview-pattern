
/*
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/


class Solution {
	public Node inorderSuccessor(Node root, Node x) {
	    Node successor = null;
	    Node curr = root;
	    while (curr != null) {
	        if (curr.data > x.data) {
	            successor = curr;
	            curr = curr.left;
	        } else if (curr.data <= x.data) {
	            curr = curr.right;
	        }
	    }
	    return successor;
    }
}
// TC: O(H), SC: O(1)
