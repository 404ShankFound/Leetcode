class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        // Step 1: Edge case
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        // Step 2: Build matrix
        char[][] mat = new char[rows][cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = encodedText.charAt(index++);
            }
        }

        // Step 3: Traverse diagonally
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < cols; j++) {
            int i = 0;
            int col = j;

            while (i < rows && col < cols) {
                result.append(mat[i][col]);
                i++;
                col++;
            }
        }

        // Step 4: Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}