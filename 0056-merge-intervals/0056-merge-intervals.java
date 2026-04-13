import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Add first interval
        result.add(intervals[0]);

        // Step 3: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            // Overlap
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } 
            // No overlap
            else {
                result.add(current);
            }
        }

        // Step 4: Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}