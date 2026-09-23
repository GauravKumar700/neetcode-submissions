class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(right < 0){
            return false;
        }

        int lCol = 0;
        int rCol = matrix[right].length - 1;
        while (lCol <= rCol) {
            int mid = rCol + (lCol - rCol) / 2;
            if (matrix[right][mid] == target) {
                return true;
            } else if (matrix[right][mid] > target) {
                rCol = mid - 1;
            } else {
                lCol = mid + 1;
            }
        }
        return false;
    }
}
