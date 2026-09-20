class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxWater = 0;
        while (left < right) {
            int min = Math.min(heights[left], heights[right]);
            int water = (right - left) * min;
            maxWater = Math.max(maxWater,water);
            if(heights[left] <= heights[right]){
                left++;
                while(heights[left] < min){
                    left++;
                }
            }else{
                right--;
                while(heights[right] < min){
                    right--;
                }
            }
        }
        return maxWater;
    }
}
