import java.util.Arrays;

import static java.lang.Math.max;

public class BadNeighbors {
    public int maxDonations(int[] donations) {
        final int n = donations.length;
        int[][] dp = new int[2][n];
        dp[0] = donations.clone();
        dp[1] = donations.clone();
        for (int i = 1, j = i + 1; i < n - 1; i++, j++) {
            dp[0][i] = max((i - 2 >= 0 ? dp[0][i - 2] : 0) + donations[i], dp[0][i - 1]);
            dp[1][j] = max((j - 2 >= 1 ? dp[1][j - 2] : 0) + donations[j], dp[1][j - 1]);
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = max(max(result, dp[0][i]), dp[1][i + 1]);
        }
        return result;
    }
}

