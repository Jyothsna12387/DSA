class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        //base case
        for(int i=0; i<n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int downdiag = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] =  Math.min(down, downdiag);
            }
        }
        
        return dp[0][0];
    }
}