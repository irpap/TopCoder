/**
 * SRM 289 DIV 1
 */
public class CMajor {
    public static final char[] WHITE_KEYS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    public static final boolean[] ALL_KEYS = {
            true/*A*/,
            false/*black*/,
            true/*B*/,
            true/*C*/,
            false/*black*/,
            true/*D*/,
            false/*black*/,
            true/*E*/,
            true/*F*/,
            false/*black*/,
            true/*G*/,
            false/*black*/};

    int[] keyIndex = {
            0, 2, 3, 5, 7, 8, 10
    };


    public int getLongest(String[] fragments) {
        final int[][] DP = new int[fragments.length][WHITE_KEYS.length];

        for (int i = 0; i < fragments.length; i++) {
            int[] lengthsForWhite = new int[WHITE_KEYS.length];
            for (int j = 0; j < WHITE_KEYS.length; j++) {
                lengthsForWhite[j] = isValidStart(WHITE_KEYS[j], fragments[i]) ? keysInFragment(fragments[i]) : 0;
            }
            DP[i] = lengthsForWhite;
        }

        for (int i = 1; i < DP.length; i++) {
            for (int j = 0; j < DP[i].length; j++) {
                int prevFragmentLength = DP[i - 1][j];
                DP[i][j] = (prevFragmentLength == 0) ? 0 : prevFragmentLength + DP[i][j];
            }
        }
        //find max Element the last row, and trace back the number of non zeros.
        return numberOfFragmentsInMaxMelody(DP);
    }

    private int numberOfFragmentsInMaxMelody(int[][] dp) {
        int max = dp[dp.length - 1][0];
        int maxIndex = 0;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            if (dp[dp.length - 1][i] > max) maxIndex = i;
        }
        int countNoZeros = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][maxIndex] != 0) countNoZeros++;
        }
        return countNoZeros;
    }

    private int keysInFragment(String fragment) {
        return fragment.length() - fragment.replaceAll(" ", "").length();
    }

    private boolean isValidStart(char c, String fragment) {

        int start = keyIndex[c - 'A'];
        final String[] jumps = fragment.split(" ");
        for (String j : jumps) {
            int jump = Integer.parseInt(j);
            int next = (Math.abs(start + jump)) % ALL_KEYS.length;
            if (!ALL_KEYS[next]) return false;
            start = next;
        }
        return true;

    }
}
