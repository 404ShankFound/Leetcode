class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            Set<Character> rowmap = new HashSet<>();
            Set<Character> colmap = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !rowmap.add(board[i][j])) {
                    return false;
                }

                if (board[j][i] != '.' && !colmap.add(board[j][i])) {
                    return false;
                }
            }
        }

        // Check each 3x3 box
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {

                Set<Character> box = new HashSet<>();

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {

                        if (board[i][j] != '.' && !box.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}