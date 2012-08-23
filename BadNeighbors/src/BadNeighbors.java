import java.util.Arrays;

import static java.lang.Math.max;

public class BadNeighbors {

    public int maxDonations (int[] donations) {

        final int n = donations.length;

        //dp[i] stores the max donation amount we can get from 0...i while always collecting from i.
        //the final answer would be the biggest value in the whole array cause we don't know which would be the last house of the optimal strategy
        //that's correct except for the last element in the array which is skipped cause it wouldn't account for neighboring with the first

        int[] dp = new int[n];
        dp[0] = donations[0];

        for (int i = 1; i < n - 1; i++) {
            int maxNotNeighborIndex = i;
            for (int j = 0; j < i - 1; j++) {
                if (dp[j] > dp[maxNotNeighborIndex]) { maxNotNeighborIndex = j; }
            }

            dp[i] = dp[maxNotNeighborIndex] + donations[i];
        }

        //that's correct except for the first element which is skipped.

        int[] dp2 = new int[n];
        dp2[1] = donations[1];
        for (int i = 2; i < n; i++) {
            int maxNotNeighborIndex = i;
            for (int j = 1; j < i - 1; j++) {
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