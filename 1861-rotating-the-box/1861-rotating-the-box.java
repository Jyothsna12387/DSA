class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // result matrix after 90 degree rotation
        char[][] ans = new char[n][m];

        // fill with empty cells
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = '.';
            }
        }

        // process each row
        for(int i = 0; i < m; i++) {

            int empty = n - 1;

            // move from right to left
            for(int j = n - 1; j >= 0; j--) {

                // obstacle
                if(boxGrid[i][j] == '*') {

                    ans[j][m - 1 - i] = '*';

                    // next stone should fall before obstacle
                    empty = j - 1;
                }

                // stone
                else if(boxGrid[i][j] == '#') {

                    ans[empty][m - 1 - i] = '#';
                    empty--;
                }
            }
        }

        return ans;
    }
}