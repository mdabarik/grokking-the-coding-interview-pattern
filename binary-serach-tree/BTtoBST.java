class Solution {
    int index = 0;
    Node binaryTreeToBST(Node root) {
        // base case
        if (root == null) return root;
        // find out inorder traversal
        ArrayList<Integer> inorderTraversal = new ArrayList<>();
        inorder(root, inorderTraversal);
        // sorting inorder of binary tree
        Collections.sort(inorderTraversal);
        // convert BT -> BST (update the node values)
        updateNode(root, inorderTraversal);
        return root;
    }
    void inorder(Node root, ArrayList<Integer> inorderTraversal) {
        // base case
        if (root == null) return;
        // recursive case
        inorder(root.left, inorderTraversal);
        inorderTraversal.add(root.data);
        inorder(root.right, inorderTraversal);
    }
    void updateNode(Node root, ArrayList<Integer> inorderTraversal) {
        // base case
        if (root == null) return;
        // recursive case
        updateNode(root.left, inorderTraversal);
        root.data = inorderTraversal.get(index++);
        updateNode(root.right, inorderTraversal);
    }
}

// TC: O(n log n), SC: O(n)


