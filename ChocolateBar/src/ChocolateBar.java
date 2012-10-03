public class ChocolateBar {

    public int maxLength (String letters) {
        int max = 0;
        int n = letters.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = letters.substring(i, j + 1);
                if (unique(substring)) { max = Math.max(max, substring.length()); }
            }
        }
        return max;
    }

    private boolean unique (final String letters) {
        int[] counts = new int[26];
        for (char c : letters.toCharArray()) {
            if (++counts[c - 'a'] > 1) { return false; }
        }
        return true;
    }
}
