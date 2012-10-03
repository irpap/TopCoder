public class DigitsSum {
    public int lastDigit(int n) {
        int res = 0;
        while (n > 9) {
            while (n > 0) {
                res += n % 10;
                n /= 10;
            }
            n = res;
            res = 0;
        }
        return n;
    }
}
