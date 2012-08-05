package div1.easy;

/** SRM 144 */
public class BinaryCode {

    public String[] decode (String encrypted) {
        StringBuilder decoded0 = new StringBuilder();
        decoded0.append('0');
        String first = decode(encrypted, decoded0);
        StringBuilder decoded1 = new StringBuilder();
        decoded1.append('1');
        String second = decode(encrypted, decoded1);
        String[] result = {first, second};
        return result;
    }

    private String decode (String encrypted, StringBuilder decoded) {
        int l = encrypted.length();
        for (int i = 0; i < l - 1; i++) {
            int next;
            if (i == 0) { next = toNum(encrypted.charAt(i)) - toNum(decoded.charAt(i)); } else {
                next = toNum(encrypted.charAt(i)) - toNum(decoded.charAt(i - 1)) - toNum(decoded.charAt(i));
            }
            if (next < 0 || next > 1) { return "NONE"; }
            decoded.append(toChar(next));
        }
        if (l == 1 && encrypted.charAt(0) != decoded.charAt(0)) { return "NONE"; }

        if (l > 1 && toNum(encrypted.charAt(l - 1)) != toNum(decoded.charAt(l - 2)) + toNum(decoded.charAt(l - 1))) {
            return "NONE";
        }

        return decoded.toString();
    }

    public int toNum (char c) {
        return c - '0';
    }

    public char toChar (int n) {
        return (char) (n + '0');
    }
}
