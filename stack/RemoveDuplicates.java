class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!staFck.isEmpty()) {
                if (stack.peek() == ch) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}
1047. 


// TC: O(n), SC: O(n)