class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int correctIndex = temp - 1;
            while (i != correctIndex) {
                if (nums[correctIndex] == temp) {
                    return temp;
                }
                swap(nums, i, correctIndex);
                temp = nums[i];
                correctIndex = temp - 1;
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
