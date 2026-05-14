class Solution {
    public boolean isGood(int[] nums) {

        int max = 0;

        // Find maximum element
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int n = max;

        // Length should be n + 1
        if (nums.length != n + 1) {
            return false;
        }

        // Frequency array
        int[] freq = new int[n + 1];

        // Count frequency
        for (int num : nums) {

            // invalid number
            if (num > n) {
                return false;
            }

            freq[num]++;
        }

        // 1 to n-1 should appear once
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        // n should appear twice
        if (freq[n] != 2) {
            return false;
        }

        return true;
    }
}