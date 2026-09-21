class Solution {
    private int helper(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        } else {
            if (b == 0) {
                return -1;
            }
            return a / b;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        // int res;
        for (int i = 0; i < tokens.length; i++) {
            if ((tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) && st.size() >= 2) {
                int b = st.pop();
                int a = st.pop();
                int res = helper(a, b, tokens[i].charAt(0));
                st.push(res);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.isEmpty() ? 0 : st.pop();
    }
}
