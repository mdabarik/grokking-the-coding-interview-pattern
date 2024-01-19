class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            // +, -, *, /
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int topMost = stack.pop();
                int secondTopMost = stack.pop();
                stack.push(secondTopMost - topMost);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int topMost = stack.pop();
                int secondTopMost = stack.pop();
                stack.push(secondTopMost / topMost);
            } else {
                int value = Integer.parseInt(token);
                stack.push(value);
            }
        }
        return stack.pop();
    }
}
// TC: O(n), SC: O(n)