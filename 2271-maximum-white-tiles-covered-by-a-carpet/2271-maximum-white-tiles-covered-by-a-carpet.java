class Solution {
public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));

    int n = tiles.length;
    int maxTiles = 0;
    int covered = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
        int carpetEnd = tiles[i][0] + carpetLen - 1;
        while (j < n && tiles[j][1] <= carpetEnd) {
            covered += tiles[j][1] - tiles[j][0] + 1;
            j++;
        }
        int current = covered;
        if (j < n && tiles[j][0] <= carpetEnd) {
            current += carpetEnd - tiles[j][0] + 1;
        }
        maxTiles = Math.max(maxTiles, current);
        if (j > i) {
            covered -= tiles[i][1] - tiles[i][0] + 1;
        } else {
            j = i + 1;
        }
    }
    return maxTiles;
}

}