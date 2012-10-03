public class ColorfulChocolates {

    public int maximumSpread (String chocolates, int maxSwaps) {
        int result = 1;

        for (int start = 0; start < chocolates.length(); start++) {
            for (int i = start; i < chocolates.length(); i++) {
                int x = 0;
                int cost = 0;
                for (int pos = 0; pos < chocolates.length(); pos++) {
                    //find the costs to move each letter
                    if (chocolates.charAt(pos) == chocolates.charAt(i)) {
                        cost += Math.abs(start + x - pos);
                        x++;
                        if (cost <= maxSwaps) {
                            result = Math.max(result, x);
                        }
                    }
                }
            }
        }
        return result;
    }
}