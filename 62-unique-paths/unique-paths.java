class Solution {
    public int uniquePaths(int m, int n) {
        
        if(m==0||n==0){
            return 1;
        }

        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }for(int j=0;j<m;j++){
            dp[j][0]=1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
               int top = dp[i-1][j];
               int left = dp[i][j-1];
               dp[i][j] = top + left;
            }
        }
        return dp[m-1][n-1];
    }
}