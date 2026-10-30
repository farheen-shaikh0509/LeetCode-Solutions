class Solution {
    public boolean makePalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int mismatches = 0;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                mismatches++;
                if (mismatches > 2) {
                    return false;
                }
            }
            left++;
            right--;
        }
        
        return true;
    }
}