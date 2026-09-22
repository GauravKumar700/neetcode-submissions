class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return -1;
        }
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        // st.push(0);

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int index = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int area = width * heights[index];
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int index = st.pop();
            int width = st.isEmpty() ? heights.length : heights.length - st.peek() - 1;
            int area = width * heights[index];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
