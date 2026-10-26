import java.util.Arrays;

public class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        if (score == null || score.length == 0 || score[0].length == 0 || k < 0 || k >= score[0].length) {
            return score;
        }

        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));

        return score;
    }
}