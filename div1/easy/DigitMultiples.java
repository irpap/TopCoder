package div1.easy;

public class DigitMultiples {

    /**
     *  SRM 241 DIV 1
     * You are given two strings of digits, single and multiple. Your job is to find the length of the longest substring (which may be the whole string) of digits in single such that there is a corresponding substring (of the same length) in multiple which satisfies the following constraint. Each digit in the substring of multiple is the same exact integer multiple of the corresponding digit in the substring of single. So "48" is a multiple (4) of "12", but "72" is not a multiple of "36". Multiplication factors from 0 to 9 are possible. Leading zeros are *allowed* in single and multiple and all substrings.
     * For example: in "3211113321571" and "5555266420", here are a few (but not all) of the multiples:
     * "3211113321571"        "5555266420"
     * "-----------7-"  x 0 = "---------0"
     * "--------2----"  x 1 = "----2-----"
     * "--11---------"  x 6 = "-----66---"
     * "321----------"  x 2 = "------642-"
     * "--1111-------"  x 5 = "5555------"
     * "-----13321---"  x 2 = "----26642-"
     * The answer is 5, the length of the longest string with a multiple, "13321".
     */
    public int getLongest(String single, String multiple) {

        int longest = 0;
        for (int i = 0; i <= 9; i++) {
            int l = longestCommonMultipliedSubstring(single, multiple, i);
            if (l > longest) longest = l;
        }
        return longest;
    }

    int longestCommonMultipliedSubstring(String a, String b, int mult) {
        int longest = 0;
        final int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if ((a.charAt(i) - '0') * mult == b.charAt(j) - '0') {
                    final int length = dp[i][j] + 1;
                    dp[i + 1][j + 1] = length;
                    if (length > longest)
                        longest = length;
                }
            }
        }
        return longest;
    }

}
