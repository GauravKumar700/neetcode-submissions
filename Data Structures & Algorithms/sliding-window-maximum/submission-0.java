class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        int[] ans = new int[nums.length - k + 1];

        for(int i = 0;i < nums.length;i++){
            pq.offer(new Pair<>(nums[i],i));
            if(i >= k - 1){
                while(pq.peek().getValue() < i - k + 1){
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek().getKey();
            }
        }

        return ans;
    }
}
