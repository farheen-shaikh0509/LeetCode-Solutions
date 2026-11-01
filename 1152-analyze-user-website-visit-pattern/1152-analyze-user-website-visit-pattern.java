class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        int n = username.length;
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            order.add(i);
        }

        Collections.sort(order, (a, b) -> timestamp[a] - timestamp[b]);
        Map<String, List<String>> map = new HashMap<>();

        for (int i : order) {
            map.computeIfAbsent(username[i], k -> new ArrayList<>())
               .add(website[i]);
        }
        Map<List<String>, Integer> count = new HashMap<>();
        for (List<String> sites : map.values()) {
            Set<List<String>> seen = new HashSet<>();
            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        List<String> pattern = Arrays.asList(
                            sites.get(i),
                            sites.get(j),
                            sites.get(k)
                        );

                        if (seen.add(pattern)) {
                            count.put(pattern, count.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }
        List<String> result = new ArrayList<>();
        int maxCount = 0;

        for (List<String> pattern : count.keySet()) {

            int frequency = count.get(pattern);

            if (frequency > maxCount ||
                (frequency == maxCount &&
                 compare(pattern, result) < 0)) {

                maxCount = frequency;
                result = pattern;
            }
        }

        return result;
    }
    private int compare(List<String> a, List<String> b) {

        if (b.isEmpty()) return -1;

        for (int i = 0; i < 3; i++) {
            int cmp = a.get(i).compareTo(b.get(i));

            if (cmp != 0) return cmp;
        }

        return 0;
    }
}