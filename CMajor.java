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

    private static HashMap<String, HashMap<Character, LengthFragmentCount>> lengthsMemo = new HashMap<String, HashMap<Character, LengthFragmentCount>>();

    public int getLongest(String[] fragments) {
        initialiseMap(fragments);
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
        LengthFragmentCount lengthIncluding = new LengthFragmentCount(0, 0);
        if (endPoint != INVALID) {
            final LengthFragmentCount found = lengthsMemo.get(head).get(endPoint);
            if (found != null && found.length != 0) {
                lengthIncluding = new LengthFragmentCount(found.length + keysInFragment(head), found.fragmentCount + 1);
            } else {
                final LengthFragmentCount restLength = longestMelodyLength(fragments, endPoint, fragmentCount + 1);
                saveToMemo(startingKey, head, restLength);
                lengthIncluding = new LengthFragmentCount(restLength.length + keysInFragment(head), restLength.fragmentCount);
            }
        }

        //don't include the first fragment
        LengthFragmentCount lengthExcluding = new LengthFragmentCount(0, 0);
        final LengthFragmentCount found = lengthsMemo.get(head).get(startingKey);
        if (found != null && found.length != 0) {
            lengthExcluding = found;
        } else {
            lengthExcluding = longestMelodyLength(fragments, startingKey, fragmentCount);
            saveToMemo(startingKey, head, lengthExcluding);
        }
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

    private void saveToMemo(char startingKey, String head, LengthFragmentCount restLength) {
        final HashMap<Character, LengthFragmentCount> mapToSaveTo = lengthsMemo.get(head);
        mapToSaveTo.put(startingKey, restLength);
    }

    private void initialiseMap(String[] fragments) {
        for (String fragment : fragments) {
            for (char whiteKey : WHITE_KEYS) {
                final HashMap<Character, LengthFragmentCount> valueMap = new HashMap<Character, LengthFragmentCount>();
                valueMap.put(whiteKey, new LengthFragmentCount(0, 0));
                lengthsMemo.put(fragment, valueMap);
            }

        }
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
