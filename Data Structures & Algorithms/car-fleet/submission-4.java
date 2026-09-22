class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] posSpd = new int[n][2];
        for (int i = 0; i < n; i++) {
            posSpd[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(posSpd, (a, b) -> b[0] - a[0]);

        double lastTime = 0.0;
        int fleet = 0;
        for (int[] ps : posSpd) {
            double time = ((target - ps[0]) * 1.0) / ps[1];
            if(time > lastTime){
                fleet++;
                lastTime = time;
            }
        }
        return fleet;
    }
}
