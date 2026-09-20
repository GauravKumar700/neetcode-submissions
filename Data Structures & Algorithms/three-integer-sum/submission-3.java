class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = (0 - nums[i]);
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // set.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    list.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        // return new ArrayList<>(set);
        return list;
    }
}
