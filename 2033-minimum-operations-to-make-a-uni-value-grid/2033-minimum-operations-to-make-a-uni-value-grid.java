import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m*n];
        int k = 0;

        // Step 1: Flatten
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[k++] = grid[i][j];
            }
        }

        // Step 2: Modulo check
        int base = arr[0] % x;
        for(int val : arr){
            if(val % x != base){
                return -1;
            }
        }

        // Step 3: Sort
        Arrays.sort(arr);

        // Step 4: Correct median
        int median = arr[arr.length / 2];

        // Step 5: Operations
        int operations = 0;
        for(int num : arr){
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}