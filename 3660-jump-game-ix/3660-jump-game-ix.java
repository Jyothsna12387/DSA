class Solution {

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Step 1: Precompute Prefix Maximums
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        
        // Step 2: Precompute Suffix Minimums
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        // Step 3: Identify components and fill answers
        int start = 0;
        for (int i = 0; i < n; i++) {
            
            if (i == n - 1 || prefixMax[i] <= suffixMin[i + 1]) {
                int componentMax = prefixMax[i];
                
                // All indices in this reachable block get the same max value
                for (int j = start; j <= i; j++) {
                    ans[j] = componentMax;
                }
                start = i + 1;
            }
        }
        
        return ans;
    }
}