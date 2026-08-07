class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        
        //base case
        for(int i=0; i<n; i++){
            front[i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2; i>=0; i--){
            int[] curr = new int[n];
            for(int j=0; j<=i; j++){
                int down = triangle.get(i).get(j) + front[j];
                int downdiag = triangle.get(i).get(j) + front[j+1];

                curr[j] =  Math.min(down, downdiag);
            }
            front = curr;
        }
        return front[0];
    }
}