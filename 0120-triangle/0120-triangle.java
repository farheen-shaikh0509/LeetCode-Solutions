class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int currentVal = triangle.get(i).get(j);
                int lowerLeft = triangle.get(i + 1).get(j);
                int lowerRight = triangle.get(i + 1).get(j + 1);
                
                triangle.get(i).set(j, currentVal + Math.min(lowerLeft, lowerRight));
            }
        }
        return triangle.get(0).get(0);
    }
}