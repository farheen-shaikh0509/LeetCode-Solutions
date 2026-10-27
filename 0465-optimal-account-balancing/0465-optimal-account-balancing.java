class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();
        for (int[] t : transactions) {
            balanceMap.put(t[0], balanceMap.getOrDefault(t[0], 0) - t[2]);
            balanceMap.put(t[1], balanceMap.getOrDefault(t[1], 0) + t[2]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int val : balanceMap.values()) {
            if (val != 0) {
                list.add(val);
            }
        }
        
        return dfs(0, list);
    }
    
    private int dfs(int idx, List<Integer> list) {
        while (idx < list.size() && list.get(idx) == 0) {
            idx++;
        }
        if (idx == list.size()) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = idx + 1; i < list.size(); i++) {
            if (list.get(idx) * list.get(i) < 0) {
                list.set(i, list.get(i) + list.get(idx));
                res = Math.min(res, 1 + dfs(idx + 1, list));
                list.set(i, list.get(i) - list.get(idx));
            }
        }
        return res;
    }
}