class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Smallest Prime Factor sieve
        int[] spf = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        // Map prime -> indices divisible by that prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            Set<Integer> primes = new HashSet<>();

            while (x > 1) {
                int p = spf[x];
                primes.add(p);

                while (x % p == 0) {
                    x /= p;
                }
            }

            for (int p : primes) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1) return steps;

                // Adjacent left
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                // Adjacent right
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // Prime teleport
                int val = nums[i];

                if (isPrime(val, spf) && !usedPrime.contains(val)) {

                    for (int next : map.getOrDefault(val, Collections.emptyList())) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    usedPrime.add(val);
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x, int[] spf) {
        return x >= 2 && spf[x] == x;
    }
}