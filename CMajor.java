import java.util.*;

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

    public int getLongest(String[] fragments) {
        final LinkedList<String> fragmentList = new LinkedList<String>(Arrays.asList(fragments));
        final ArrayList<LengthFragmentCount> lengthFragmentCounts = new ArrayList<LengthFragmentCount>();
        for (char whiteKey : WHITE_KEYS) {
            final LengthFragmentCount lengthFragmentCount = longestMelodyLength(fragmentList, whiteKey, 0);
            lengthFragmentCounts.add(lengthFragmentCount);
            System.out.println(whiteKey + ": " + lengthFragmentCount.length + "  #fragments: " + lengthFragmentCount.fragmentCount);
        }

        final LengthFragmentCount longest = Collections.max(lengthFragmentCounts);
        return longest.fragmentCount;

    }

    public LengthFragmentCount longestMelodyLength(LinkedList<String> fragments, char startingKey, int fragmentCount) {
        if (fragments.isEmpty()) return new LengthFragmentCount(0, fragmentCount);
        if (startingKey == INVALID) return new LengthFragmentCount(0, fragmentCount);

        //include the first fragment
        final String head = fragments.removeFirst();
        final char endPoint = endOfFragment(startingKey, head);
        final LengthFragmentCount restLength = longestMelodyLength(fragments, endPoint, fragmentCount + 1);
        LengthFragmentCount lengthIncluding = new LengthFragmentCount(restLength.length + keysInFragment(head), restLength.fragmentCount);
        //don't include the first fragment
        final LengthFragmentCount lengthExcluding = longestMelodyLength(fragments, startingKey, fragmentCount);

        //put the head back so that we don't destroy the collection for the next person
        fragments.addFirst(head);
        return lengthIncluding.length > lengthExcluding.length ? lengthIncluding : lengthExcluding;
    }

    private int keysInFragment(String fragment) {
        return fragment.length() - fragment.replaceAll(" ", "").length() + 1;
    }

    /**
     * If this fragment can be played with this starting key, it returns the end key. If any black key is encountered returns INVALID.
     */
    private char endOfFragment(char c, String fragment) {
        int start = keyIndex[c - 'A'];
        final String[] jumps = fragment.split(" ");
        for (String j : jumps) {
            int jump = Integer.parseInt(j);
            int next = (Math.abs(start + jump)) % ALL_KEYS.length;
            if (!ALL_KEYS[next]) {
                return INVALID;
            }
            start = next;
        }
        return ALL_KEYS[start] ? whiteKeyForIndex(start) : INVALID;

    }

    private char whiteKeyForIndex(int whiteKey) {
        for (int i = 0; i < keyIndex.length; i++) {
            if (whiteKey == keyIndex[i]) return (char) (i + 'A');
        }
        return INVALID;
    }

    private static class LengthFragmentCount implements Comparable {
        private LengthFragmentCount(int length, int fragmentCount) {
            this.length = length;
            this.fragmentCount = fragmentCount;
        }

        int length;
        int fragmentCount;

        public int compareTo(Object another) {
            return this.length - ((LengthFragmentCount) (another)).length;
        }
    }
}
