class Solution {
    int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        if (arr[0] == 0)
            return -1;

        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {

            farthest = Math.max(farthest, i + arr[i]);

            if (i == end) {

                if (farthest == end)
                    return -1;

                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
}