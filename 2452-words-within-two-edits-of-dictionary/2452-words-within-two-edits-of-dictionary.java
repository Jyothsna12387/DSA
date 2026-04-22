class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            for (int j = 0; j < dictionary.length; j++) {
                String d = dictionary[j];

                int diff = 0;

                // 🔥 FIX: add this loop
                for (int k = 0; k < q.length(); k++) {
                    if (q.charAt(k) != d.charAt(k)) {
                        diff++;
                    }
                    if (diff > 2) break;
                }

                if (diff <= 2) {
                    list.add(q);
                    break;
                }
            }
        }

        return list;
    }
}