/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> leftViews = new ArrayList<>();
        dfs(root, leftViews, 0);
        return leftViews;
    }
    public void dfs(Node root, ArrayList<Integer> leftViews, int currLevel) {
        // base case
        if (root == null) return;
        if (leftViews.size() == currLevel) {
            leftViews.add(root.data);
        }
        // recursive case
        dfs(root.left, leftViews, currLevel + 1);
        dfs(root.right, leftViews, currLevel + 1);
    }
}
// TC: O(n), SC: O(h)


