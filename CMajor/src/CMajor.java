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
    private String[] fragments;

    boolean isWhite(int k) {
        for (int key : whiteKeys) if (k == key) return true;
        return false;
    }

    public int getLongest(String[] fragments) {

        int longest = 0;
        this.fragments = fragments;
        n = fragments.length;
        int subsets = 1 << n;
        for (final int startKey : whiteKeys) {
            subset:
            for (int mask = subsets - 1; mask > 0; mask--) {
                int endKey = startKey;
                for (int i = 0; i < n; i++) {
                    if ((mask & 1 << i) != 0) {
                        endKey = play(endKey, fragments[i]);
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

    private int play(int key, String fragment) {
        if (!isWhite(key)) return -1;
        String[] jumps = fragment.split(" ");
        for (String jump : jumps) {
            Integer intJump = Integer.valueOf(jump);
            key = (key + intJump) % keys;
            if (key < 0) key = keys + key;
            if (!isWhite(key)) return -1;
        }
        return key;
    }
}
