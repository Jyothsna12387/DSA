class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = max;

        // length should be n + 1
        if (nums.length != n + 1) {
            return false;
        }

        // 1 to n-1 should appear once
        for (int i = 1; i < n; i++) {
            if (!map.containsKey(i) || map.get(i) != 1) {
                return false;
            }
        }

        // n should appear twice
        if (map.get(n) != 2) {
            return false;
        }

        return true;
    }
}