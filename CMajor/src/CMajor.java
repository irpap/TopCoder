import java.util.Arrays;

import static java.lang.Math.max;

/**
 * SRM 289 DIV 1
 */
public class CMajor {
    int n;
    static final int keys = 12;
    static final int[] whiteKeys = {0, 2, 3, 5, 7, 8, 10};
    static final boolean[] isWhite = new boolean[keys];
    static {
        for (int whiteKey : whiteKeys) isWhite[whiteKey] = true;
    }

    int[][] play;
    String[] fragments;

    public int getLongest(String[] fragm) {
        n = fragm.length;
        fragments = fragm;
        play = new int[keys][n];  for (int[] p : play) Arrays.fill(p, -2);

        int longest = 0;
        for (final int startKey : whiteKeys) {
            subset:
            for (int mask = 1; mask < 1 << n; mask++) {
                int endKey = startKey;
                for (int i = 0; i < n; i++) if ((mask & 1 << i) != 0) {
                    endKey = play(endKey, i);
                    if (endKey < 0) continue subset;
                }
                longest = max(longest, length(mask));
            }
        }
        return longest;
    }

    private int length(int mask) {
        int l = 0;
        for (int i = 0; i < n; i++) if ((mask & 1 << i) != 0) ++l;
        return l;
    }

    /**
     * Ending key if we play fragment f starting from key, or -1 if we hit any black key on the way
     */
    private int play(int key, int f) {
        if (play[key][f] != -2) return play[key][f];
        String[] jumps = fragments[f].split(" ");
        for (String jump : jumps) {
            key = (key + Integer.valueOf(jump)) % keys;
            if (key < 0) key = keys + key;
            if (!isWhite[key]) {
                play[key][f] = -1;
                return -1;
            }
        }
        play[key][f] = key;
        return key;
    }
}
