import java.util.Arrays;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[j][c] = max score at column j with cost c
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Base case: (0, 0)
        int startVal = grid[0][0];
        int startCost = (startVal == 0) ? 0 : 1;
        if (startCost <= k) dp[0][startCost] = startVal;
        else return -1;

        for (int i = 0; i < m; i++) {
            // Use a temporary row to avoid using updated values from the same row
            int[][] nextDp = new int[n][k + 1];
            for (int[] row : nextDp) Arrays.fill(row, -1);

            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                int stepCost = (val == 0) ? 0 : 1;

                for (int c = stepCost; c <= k; c++) {
                    int prevMax = -1;
                    
                    // Logic for (0,0) only on the first iteration
                    if (i == 0 && j == 0) {
                        if (c == startCost) nextDp[j][c] = startVal;
                        continue;
                    }

                    // Top neighbor: Use dp[j] from the PREVIOUS row
                    if (i > 0) prevMax = Math.max(prevMax, dp[j][c - stepCost]);
                    
                    // Left neighbor: Use nextDp[j-1] from the CURRENT row
                    if (j > 0) prevMax = Math.max(prevMax, nextDp[j - 1][c - stepCost]);

                    if (prevMax != -1) {
                        nextDp[j][c] = prevMax + val;
                    }
                }
            }
            dp = nextDp; // Move to the next row
        }

        int maxScore = -1;
        for (int c = 0; c <= k; c++) {
            maxScore = Math.max(maxScore, dp[n - 1][c]);
        }
        return maxScore;
    }
}