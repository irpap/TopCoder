import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.max;

/**
 * SRM 289 DIV 1
 */
public class CMajor {
    final int keys = 12;
    int[] whiteKeys = {0, 2, 3, 5, 7, 8, 10};
    int n;
    int[][] play;
    private String[] fragments;

    boolean isWhite(int k) {
        for (int key : whiteKeys) if (k == key) return true;
        return false;
    }

    public int getLongest(String[] fragments) {
        int longest = 0;
        this.fragments = fragments;
        n = fragments.length;
        play = new int[keys][n];
        for (int[] ints : play) Arrays.fill(ints, -2);

        for (final int startKey : whiteKeys) {
            subset:
            for (int mask = (1 << n) - 1; mask > 0; mask--) {
                int endKey = startKey;
                for (int i = 0; i < n; i++) {
                    if ((mask & 1 << i) != 0) {
                        endKey = play(endKey, i);
                        if (endKey < 0) continue subset;
                    }
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
            Integer intJump = Integer.valueOf(jump);
            key = (key + intJump) % keys;
            if (key < 0) key = keys + key;
            if (!isWhite(key)) {
                play[key][f] = -1;
                return -1;
            }
        }
        play[key][f] = key;
        return key;
    }
}
