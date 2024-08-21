class Solution
{
    private static int minStepsHelper(int KnightPos[], int TargetPos[], int[][] dp) {
		// If knight is on the target position return 0.
		if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
			return 0;
		} else {
			// If already calculated then return that value.
			if (dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
					.abs(KnightPos[1] - TargetPos[1])] != 0) {
				return dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])];
			} else {
				int x1, y1, x2, y2;
				// (x1, y1) and (x2, y2) are the two positions which will be considered.
				if (KnightPos[0] <= TargetPos[0]) {
					if (KnightPos[1] <= TargetPos[1]) {
						x1 = KnightPos[0] + 2;
						y1 = KnightPos[1] + 1;
						x2 = KnightPos[0] + 1;
						y2 = KnightPos[1] + 2;
					} else {
						x1 = KnightPos[0] + 2;
						y1 = KnightPos[1] - 1;
						x2 = KnightPos[0] + 1;
						y2 = KnightPos[1] - 2;
					}
				} else {
					if (KnightPos[1] <= TargetPos[1]) {
						x1 = KnightPos[0] - 2;
						y1 = KnightPos[1] + 1;
						x2 = KnightPos[0] - 1;
						y2 = KnightPos[1] + 2;
					} else {
						x1 = KnightPos[0] - 2;
						y1 = KnightPos[1] - 1;
						x2 = KnightPos[0] - 1;
						y2 = KnightPos[1] - 2;
					}
				}

				dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])] = Math.min(
								minStepsHelper(new int[]{x1, y1}, TargetPos, dp),
								minStepsHelper(new int[]{x2, y2}, TargetPos, dp)) + 1;

				/*
					Exchanging the coordinates x with y of both knight and target will result in
				 	same ans.
				*/
				dp[Math.abs(KnightPos[1] - TargetPos[1])][Math.abs(KnightPos[0]
						- TargetPos[0])] = dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
								.abs(KnightPos[1] - TargetPos[1])];
				return dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])];
			}
		}
	}

	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int size) {
		int dp[][] = new int[size + 2][size + 2];
		
		// There are 4 corner cases for which the minimum steps is 4.
		if ((KnightPos[0] == 1 && KnightPos[1] == 1 && TargetPos[0] == 2
				&& TargetPos[1] == 2)
				|| (KnightPos[0] == 2 && KnightPos[1] == 2 && TargetPos[0] == 1
						&& TargetPos[1] == 1)) {
			return 4;
		} else if ((KnightPos[0] == 1 && KnightPos[1] == size && TargetPos[0] == 2
				&& TargetPos[1] == size - 1)
				|| (KnightPos[0] == 2 && KnightPos[1] == size - 1 && TargetPos[0] == 1
						&& TargetPos[1] == size)) {
			return 4;
		} else if ((KnightPos[0] == size && KnightPos[1] == 1 && TargetPos[0] == size - 1
				&& TargetPos[1] == 2)
				|| (KnightPos[0] == size - 1 && KnightPos[1] == 2 && TargetPos[0] == size
						&& TargetPos[1] == 1)) {
			return 4;
		} else if ((KnightPos[0] == size &&KnightPos[1] == size && TargetPos[0] == size - 1
				&& TargetPos[1] == size - 1)
				|| (KnightPos[0] == size - 1 && KnightPos[1] == size - 1
						&& TargetPos[0] == size && TargetPos[1] == size)) {
			return 4;
		} else {
			dp[1][0] = 3;
			dp[0][1] = 3;
			dp[1][1] = 2;
			dp[2][0] = 2;
			dp[0][2] = 2;
			dp[2][1] = 1;
			dp[1][2] = 1;
			return minStepsHelper(KnightPos, TargetPos, dp);
		}
	}
}
