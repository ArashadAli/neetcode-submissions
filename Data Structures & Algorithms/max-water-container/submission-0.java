class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length - 1;
        int left = 0, right = len;
        int minHeight = -1;
        int area =  -1;
        while(left < right) {
            if(heights[left] < heights[right]) {
                minHeight = heights[left];
                area = Math.max(area, minHeight * len);
                left++;
                len--;
            }
            else {
                minHeight = heights[right];
                area = Math.max(area, minHeight * len);
                len--;
                right--;
            }
        }
        return area;
    }
}
