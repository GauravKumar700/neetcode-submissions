class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        leftSum[0] = 1;
        for(int i = 1;i < n;i++){
            leftSum[i] = nums[i-1] * leftSum[i - 1];
        }

        rightSum[n-1] = 1;
        for(int i = n-1;i > 0;i--){
            rightSum[i-1] = nums[i] * rightSum[i];
        }

        int[] ans = new int[n];
        for(int i = 0;i < n;i++){
            ans[i] = leftSum[i] * rightSum[i];
        }
        return ans;
    }
}  
