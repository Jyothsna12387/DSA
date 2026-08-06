class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if(obstacleGrid[0][0] == 1) return 0;  //if starting cell is -1, we cannot go to any other cell

       int m = obstacleGrid.length;
       int n = obstacleGrid[0].length;
       int[] prev = new int[n];
        
        for(int i=0; i<m; i++){
            int[] curr = new int[n];
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) {
                    curr[0] = 1;
                    continue;
                }
                int up = i>0 ? prev[j] : 0;
                int left = j>0 ? curr[j-1] : 0;

                curr[j] =  up + left;
            }
            prev = curr;
        }
        return prev[n-1];
    }
}