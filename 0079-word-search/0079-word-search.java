class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Start searching from the rarer end of the word
        if (boardCount(board, word.charAt(0)) >
            boardCount(board, word.charAt(word.length() - 1))) {
            word = new StringBuilder(word).reverse().toString();
        }

        //  starting the search from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int i, int j, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark this cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore four directions
        boolean found =
            dfs(board, word, i + 1, j, index + 1) ||
            dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) ||
            dfs(board, word, i, j - 1, index + 1);

        // Restore the original character
        board[i][j] = temp;

        return found;
    }

    // Count occurrences of a character on the board
    private int boardCount(char[][] board, char target) {
        int count = 0;

        for (char[] row : board) {
            for (char c : row) {
                if (c == target) {
                    count++;
                }
            }
        }

        return count;
    }
}