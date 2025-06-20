public class leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        // Arrays to keep track of seen digits
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];

                if (ch != '.') {
                    int num = ch - '1'; // Convert char to 0-based index
                    int boxIndex = (r / 3) * 3 + (c / 3);

                    if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                        return false; // Duplicate found
                    }

                    rows[r][num] = true;
                    cols[c][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }
}
