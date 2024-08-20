class Solution {
        public int minInsertions(String s) {
        return s.length() - lcs(s, new StringBuilder(s).reverse().toString());
    }
    private int lcs(String s, String r) {
        int n = s.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[1 - i % 2][j + 1] = s.charAt(i) == r.charAt(j) ? 1 + dp[i % 2][j] : Math.max(dp[1 - i % 2][j], dp[i % 2][j + 1]);
            }
        }
        return dp[n % 2][n];        
    }
}
