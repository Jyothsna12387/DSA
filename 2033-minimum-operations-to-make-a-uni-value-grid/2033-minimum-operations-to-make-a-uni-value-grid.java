class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        int k = 0;
        //step 1: flatten array(convert 2D array to 1D array)
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[k] = grid[i][j];
                k++;
            }
        }

        //check modulo
        int base = arr[0] % x;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % x != base){
                return -1;
            }
        }

        Arrays.sort(arr);

        int median = arr[arr.length / 2];

        //calculate operations
        int operations = 0;
        for(int num : arr){
            operations += Math.abs(num-median) / x;
        }
        return operations;
    }
}