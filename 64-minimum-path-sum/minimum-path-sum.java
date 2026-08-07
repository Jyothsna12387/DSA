class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];

        for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                    continue;
                }

                int up = (int)1e9;
                if(i > 0)
                    up = grid[i][j] + prev[j];

                int left = (int)1e9;
                if(j > 0)
                    left = grid[i][j] + curr[j - 1];

                curr[j] = Math.min(up, left);
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}