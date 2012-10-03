import java.util.Arrays;
import java.util.Comparator;

/**
 * Fails tests
 * SRM 145 DIV 1
 */
public class Bonuses {

    public int[] getDivision(int[] points) {
        int n = points.length;
        final int[] percentages = new int[n];

        int sum = 0;
        for (int p : points) sum += p;

        int totalPercentageGiven = 0;
        for (int i = 0; i < n; i++) {
            percentages[i] = (100 * points[i] / sum);
            totalPercentageGiven += percentages[i];
        }

        int leftOver = 100 - totalPercentageGiven;
        boolean[] gotOne = new boolean[n];

        while (leftOver > 0) {
            int nextIndex = -1;
            int maxPoints = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (!gotOne[i] && points[i] >= maxPoints) {
                    nextIndex = i;
                    maxPoints = points[i];
                }
            }
            percentages[nextIndex]++;
            gotOne[nextIndex] = true;
            leftOver--;
        }
        return percentages;
    }
}
