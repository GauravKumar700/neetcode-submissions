class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0;i < temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > st.peek().getKey()){
                int index = st.pop().getValue();
                ans[index] = i - index;
                // st.push(new)
            }
            st.push(new Pair<>(temperatures[i],i));
        }

        return ans;
    }
}
