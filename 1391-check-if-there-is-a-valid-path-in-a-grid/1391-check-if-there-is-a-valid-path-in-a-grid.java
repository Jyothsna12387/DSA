class Solution {
    // Maps street type to the two directions it connects: {row_offset, col_offset}
    // Directions: 0: up, 1: right, 2: down, 3: left
    private int[][][] directions = {
        {}, // Placeholder for index 0
        {{0, -1}, {0, 1}},  // 1: left, right
        {{-1, 0}, {1, 0}},  // 2: up, down
        {{0, -1}, {1, 0}},  // 3: left, down
        {{0, 1}, {1, 0}},   // 4: right, down
        {{0, -1}, {-1, 0}}, // 5: left, up
        {{0, 1}, {-1, 0}}   // 6: right, up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            for (int[] dir : directions[grid[r][c]]) {
                int nr = r + dir[0], nc = c + dir[1];

                // Check bounds and if already visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // Handshake check: Can the neighbor pipe connect back to us?
                    if (canConnect(grid[nr][nc], -dir[0], -dir[1])) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    // Checks if the pipe at the target cell has an opening facing the current cell
    private boolean canConnect(int pipeType, int targetRowDir, int targetColDir) {
        for (int[] dir : directions[pipeType]) {
            if (dir[0] == targetRowDir && dir[1] == targetColDir) return true;
        }
        return false;
    }
}