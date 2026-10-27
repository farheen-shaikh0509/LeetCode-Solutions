class Solution {
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        boolean found = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '*') {
                    queue.offer(new int[]{r, c, 0});
                    grid[r][c] = 'X';
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];
            
            if (grid[r][c] == '#') {
                return steps;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != 'X') {
                    if (grid[nr][nc] == '#') {
                        return steps + 1;
                    }
                    grid[nr][nc] = 'X';
                    queue.offer(new int[]{nr, nc, steps + 1});
                }
            }
        }
        
        return -1;
    }
}