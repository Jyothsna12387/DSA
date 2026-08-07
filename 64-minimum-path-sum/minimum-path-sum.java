class Solution {
    public int solve(int i, int j, int[][] grid, int[][] dp){
        if(i<0 || j<0) return (int) 1e9;
        if(i == 0  && j == 0) return grid[0][0];

        if(dp[i][j] != -1) return dp[i][j];
        //try all possibilities  
        int up = grid[i][j] + solve(i-1, j, grid, dp);

        int left = grid[i][j] + solve(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
        
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;

                int up = (int) 1e9;
                if(i>0) {
                   up = grid[i][j] + dp[i-1][j];
                 }
                int left = (int) 1e9;
                if(j>0) {
                   left = grid[i][j] + dp[i][j-1];
                 }
             dp[i][j] = Math.min(up, left);
            }
        }
        return dp[m-1][n-1];
    }
}