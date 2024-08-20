class Solution
{
    
    public int maxCutsUtil(int n, int x, int y, int z, int[] dp) {
        // Base Cases
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        
        int ans1 = maxCutsUtil(n - x, x, y, z, dp);
        int ans2 = maxCutsUtil(n - y, x, y, z, dp);
        int ans3 = maxCutsUtil(n - z, x, y, z, dp);
        int maxCuts = Math.max(ans1, Math.max(ans2, ans3));

        // If maxCuts is valid, add one cut to it
        if (maxCuts == Integer.MIN_VALUE) {
            dp[n] = maxCuts;  // No valid cuts can be made, return 0
        } else {
            dp[n] = maxCuts + 1;
        }

        return dp[n];
    }
    
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
      int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = maxCutsUtil(n, x, y, z, dp);
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
