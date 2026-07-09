class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < len; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.peek();
                st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int element = st.peek();
            st.pop();
            int nse = len;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
        }
        return maxArea;
    }
}