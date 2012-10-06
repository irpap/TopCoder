public class LeftRightDigitsGame {
    public String minNumber(String digits) {
        String min = null;
        final int n = digits.length();
        for (int first = 0; first < n; first++) if (digits.charAt(first) != '0') { //fix the 1st digit
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    char next = digits.charAt(i);
                    if (i == first) continue;   //skip cause this is used as first digit
                    if (i < first) {            //for the digits before "first" we use optimal lexicographical order
                        String stringResult = result.toString();
                        int cmp = (next + stringResult).compareTo(stringResult + next);
                        if (cmp < 0) result.insert(0, next);
                        else result.append(next);
                    } else
                        result.append(next);   //for the digits after "first" they must all go to the end otherwise first will not be first
                }
                String potentialMin = digits.charAt(first) + result.toString();
                if (min == null || potentialMin.compareTo(min) < 0) min = potentialMin;
            }
        return min;
    }


}
