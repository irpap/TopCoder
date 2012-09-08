import java.util.Arrays;

public class CuttingBitString {
    public int getmin(String S) {
        int n = S.length();
        int[] dp = new int[n]; //dp[i] is the answer if the string ended at i
        Arrays.fill(dp, -1);
        int number;
        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(S.substring(0, i + 1), 2);
            if (isPowerOf5(number)) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < i; j++) if (dp[j] >= 0) {
                    number = Integer.parseInt(S.substring(j + 1, i + 1), 2);
                    if (isPowerOf5(number)) {
                        dp[i] = 1 + dp[j];
                        break;
                    }
            }
        }
        return dp[n - 1];

    }

    private boolean isPowerOf5(int n) {
        int i = 1;
        while (i <= n) {
            if (i == n) return true;
            i *= 5;
        }
        return false;
    }
}
