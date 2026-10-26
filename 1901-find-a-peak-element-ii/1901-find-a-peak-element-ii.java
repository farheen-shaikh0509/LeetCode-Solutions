class Solution {
    public int[] findPeakGrid(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
      int lowCol = 0, highCol = m - 1;
       while(lowCol <= highCol){
        int midCol = lowCol + (highCol - lowCol) / 2;
       int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

        
    boolean leftIsGreater = (midCol - 1 >= 0) && (mat[maxRow][midCol - 1] > mat[maxRow][midCol]);
    boolean rightIsGreater = (midCol + 1 < m) && (mat[maxRow][midCol + 1] > mat[maxRow][midCol]);

if(!leftIsGreater && !rightIsGreater){
    return new int[] { maxRow, midCol };

} else if (leftIsGreater) {
                highCol = midCol - 1;
            } else {
                lowCol = midCol + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}