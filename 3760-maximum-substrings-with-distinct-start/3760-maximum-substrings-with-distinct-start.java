class Solution {
    public int maxDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (!seen[idx]) {
                seen[idx] = true;
                ans++;
            }
        }

        return ans;
    }
}