class Node {
    int val, min;
    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if (!stack.isEmpty()) {
            min = Math.min(min, stack.peek().min);
        }
        stack.push(new Node(val, min));
    } // TC: O(1), SC: O(1)
    
    public void pop() {
        stack.pop();
    } // TC: O(1), SC: O(1)
    
    public int top() {
        return stack.peek().val;
    } // TC: O(1), SC: O(1)
    
    public int getMin() {
        return stack.peek().min;
    } // TC: O(1), SC: O(1)
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */