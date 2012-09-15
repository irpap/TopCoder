public class FavouriteDigits {

    public long findNext(long N, int digit1, int count1, int digit2, int count2) {
        while (true) {
            if (isGood(N, digit1, count1, digit2, count2)) return N;
            N++;
        }
    }

    private boolean isGood(Long n, int digit1, int count1, int digit2, int count2) {
        int found1 = 0;
        int found2 = 0;
        while (n > 0) {
            int digit = (int) (n % 10);
            n /= 10;
            if (digit == digit1) found1++;
            if (digit == digit2) found2++;
        }
        return (found1 >= count1 && found2 >= count2);
    }
}
