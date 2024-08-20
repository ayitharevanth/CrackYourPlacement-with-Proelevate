class Solution {
    public int mergeStones(int[] stones, int K) {
	int n = stones.length;
	if ((n - 1) % (K - 1) != 0) return -1;
	int[][] dp = new int[n][n];  // definition : dp[i][j] = min cost to merge [i, j]
	int[] prefixSum = new int[n + 1];
	for (int i = 1; i < n + 1; ++i) { // sum[i, j] = prefixSum[j + 1] - prefixSum[i];
		prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
	}
	for (int len = K; len <= n; ++len) {
		for (int i = 0; i + len - 1 < n; ++i) {
			int j = i + len - 1;
			dp[i][j] = Integer.MAX_VALUE;
			int l = (len - 1) % (K - 1) == 0 ? len - (K - 1) : len; // base case
			for (int k = 0; k <= len - 2; ++k) {
				if (k / (K - 1) + (len - 2 - k) / (K - 1) == (l - 1) / (K - 1)) { // check if can be merged
					int curCost = dp[i][k + i] + dp[k + i + 1][j];
					dp[i][j] = Math.min(dp[i][j], curCost);
				}
			}
			if ((len - 1) % (K - 1) == 0) dp[i][j] += prefixSum[j + 1] - prefixSum[i];
		}
	}
	return dp[0][n - 1];
}
}
