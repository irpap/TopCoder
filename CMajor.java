import java.util.LinkedList;

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
    private static final char INVALID = (char) -1;

    public int longestMelodyLength(LinkedList<String> fragments, char startingKey) {
        //try to include and to not include, return biggest
        if (fragments.isEmpty()) return 0;
        if (startingKey == INVALID) return 0;

        //include the first fragment
        final String head = fragments.pollFirst();
        final char endPoint = endOfFragment(startingKey, head);
        int lengthIncluding = keysInFragment(head) + longestMelodyLength(fragments, endPoint);

        //don't include the first fragment
        int lengthExcluding = longestMelodyLength(fragments, startingKey);

        return Math.max(lengthIncluding, lengthExcluding);
    }

    private int keysInFragment(String fragment) {
        return fragment.length() - fragment.replaceAll(" ", "").length() + 1;
    }

    /**
     * If this fragment can be played with this starting key, it returns the end key. If any black key is encountered returns INVALID.
     */
    private char endOfFragment(char c, String fragment) {
        System.out.println("starting char: " + c);
        int start = keyIndex[c - 'A'];
        final String[] jumps = fragment.split(" ");
        for (String j : jumps) {
            int jump = Integer.parseInt(j);
            int next = (Math.abs(start + jump)) % ALL_KEYS.length;
            if (!ALL_KEYS[next]) {
                System.out.println("returning INVALID");
                return INVALID;
            }
            start = next;
        }
        char result = ALL_KEYS[start] ? whiteKeyForIndex(start) : INVALID;

        System.out.println("returning: " + result);
        return result;

    }

    private char whiteKeyForIndex(int whiteKey) {
        for (int i = 0; i < keyIndex.length; i++) {
            if (whiteKey == keyIndex[i]) return (char) (i + 'A');
        }
        return INVALID;
    }
}
