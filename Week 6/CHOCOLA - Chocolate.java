import java.util.Scanner;

public class Solution {
    public static int minCost(int m, int n, int[] x, int[] y) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + x[i - 1], dp[i][j - 1] + y[j - 1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[] x = new int[m - 1];
            int[] y = new int[n - 1];

            for (int j = 0; j < m - 1; j++) {
                x[j] = sc.nextInt();
            }

            for (int j = 0; j < n - 1; j++) {
                y[j] = sc.nextInt();
            }

            int result = minCost(m, n, x, y);
            System.out.println(result);
        }

        sc.close();
    }
}
