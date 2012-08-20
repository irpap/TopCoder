import java.util.Arrays;

import static java.lang.Math.max;

public class ZigZag {

    public int longestZigZag(int[] sequence) {
        int n = sequence.length;
        //saving the length and the difference of the last 2 numbers
        int[][] dp = new int[51][2];
        dp[0] = new int[]{1, 0};
        int biggestLengthOfAll = dp[0][0];
        for (int i = 0; i < n; i++) {
            int maxCompatiblePreviousLength = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j][0] > maxCompatiblePreviousLength && isAppendable(i, j, dp, sequence)) {
                    dp[i] = new int[]{dp[j][0] + 1, sequence[i] - sequence[j]};
                    maxCompatiblePreviousLength = dp[j][0];
                    biggestLengthOfAll = max(biggestLengthOfAll, maxCompatiblePreviousLength + 1);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return biggestLengthOfAll;
    }

    private boolean isAppendable(int i, int prev, int[][] dp, int[] sequence) {
        if (prev == 0) return true; //anything goes after just the first number
        return dp[prev][1] > 0 && sequence[i] - sequence[prev] < 0 || dp[prev][1] < 0 && sequence[i] - sequence[prev] > 0;

    }

}
