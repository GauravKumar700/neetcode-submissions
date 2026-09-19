class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new Pair<>(entry.getKey(),entry.getValue()));
        }

        int[] ans = new int[k];
        for(int i = 0;i < k;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
