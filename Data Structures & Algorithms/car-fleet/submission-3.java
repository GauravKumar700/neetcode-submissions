class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] posSpd = new int[n][2];
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            posSpd[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(posSpd, (a, b) -> a[0] - b[0]);
        for (int[] ps : posSpd) {
            double time = ((target - ps[0]) * 1.0) / ps[1];
            while (!st.isEmpty() && time >= st.peek()) {
                st.pop();
            }
            st.push(time);
        }
        return st.isEmpty() ? -1 : st.size();
    }
}
