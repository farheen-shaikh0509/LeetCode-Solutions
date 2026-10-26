import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, "", result);
        return result;
    }

    private void backtrack(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
            backtrack(n, current + "0", result);
        }
        
        backtrack(n, current + "1", result);
    }
}