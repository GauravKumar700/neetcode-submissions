class Solution {
    // row check
    public boolean isValidRow(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            if (board[row][col] != '.') {
                if (set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }
        return true;
    }

    // column check
    public boolean isValidCol(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            if (board[row][col] != '.') {
                if (set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }
        return true;
    }

    // box check
    public boolean isValidBox(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // row check
        for (int row = 0; row < 9; row++) {
            if (!isValidRow(board, row)) {
                return false;
            }
        }
        // col check
        for (int col = 0; col < 9; col++) {
            if (!isValidCol(board, col)) {
                return false;
            }
        }
        // box check
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValidBox(board, row, col)) {
                    return false;
                }
            }
        }

        return true;
    }
}
