import java.util.Arrays;

import static java.lang.Math.max;

public class BadNeighbors {
    public int maxDonations (int[] donations) {
        final int n = donations.length;
        int[] dp = new int[n];
        dp[0] = donations[0];
        for (int i = 1; i < n; i++) {
            int maxNotNeighborIndex = i;
            for (int j = 0; j < i - 1; j++) {
                if (dp[j] > dp[maxNotNeighborIndex]) { maxNotNeighborIndex = j; }
            }
            dp[i] = dp[maxNotNeighborIndex] + donations[i];
        }
        //fix for last-first element
        int[] dp2 = new int[n];
        dp2[n - 1] = donations[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int maxNotNeighborIndex = i;
            for (int j = n - 1; j > i + 1; j--) {
                if (dp2[j] > dp2[maxNotNeighborIndex]) { maxNotNeighborIndex = j; }
            }
            dp2[i] = dp2[maxNotNeighborIndex] + donations[i];
        }

        int result = 0;
        for (int i = 0; i < dp.length - 1; i++) { result = max(result, dp[i]); }
        for (int i = 1; i < dp.length; i++) { result = max(result, dp2[i]); }
        return result;
    }

    private void debug (final Object... a) {
        System.out.println(Arrays.deepToString(a));
    }
}