class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 0;
        while (left <= right && right < prices.length) {
            int a = prices[left];
            int b = prices[right];
            if (b >= a) {
                int profit = b - a;
                right++;
                max = Math.max(max, profit);
            } else {
                left++;
            }
        }
        return max;
    }
}
