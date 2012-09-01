import java.util.*;

public class DerivativeSequence {
    public int[] derSeq(int[] a, int times) {
        int n = a.length;
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                a[j] = a[j + 1] - a[j];
            }
        }
        return Arrays.copyOfRange(a, 0, a.length - times);

    }

}
