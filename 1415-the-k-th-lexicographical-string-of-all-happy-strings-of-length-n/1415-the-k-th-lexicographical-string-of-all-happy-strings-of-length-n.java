import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, "", happyStrings);
        
        if (k > happyStrings.size()) {
            return "";
        }
        
        return happyStrings.get(k - 1);
    }

    private void backtrack(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        char[] chars = {'a', 'b', 'c'};
        for (char c : chars) {
            if (!current.isEmpty() && current.charAt(current.length() - 1) == c) {
                continue;
            }
            backtrack(n, current + c, result);
        }
    }
}