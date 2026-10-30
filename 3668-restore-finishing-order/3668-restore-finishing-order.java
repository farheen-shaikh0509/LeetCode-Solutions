class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        boolean[] isFriend = new boolean[order.length + 1];
        for (int f : friends) {
            isFriend[f] = true;
        }
                List<Integer> result = new ArrayList<>();
        for (int id : order) {
            if (isFriend[id]) {
                result.add(id);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}