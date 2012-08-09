import java.util.Arrays;
import java.util.Comparator;

/**
 * SRM 145 DIV 1
 */
public class Bonuses {

    public int[] getDivision(int[] points) {
        final int[] percentages = new int[points.length];
        int sum = 0;
        for (int p : points) sum += p;
        for (int i = 0; i < points.length; i++) {
            final double percent = (double) points[i] / (double) sum;
            percentages[i] = (int) (percent * 100);   //keeping 2 decimals
        }
        int percentSum = 0;
        for (int p : percentages) percentSum += p;

        //Distribute the leftover amount
        int leftOver = 100 - percentSum;
        final IndexedPercentage[] indexedPercentages = new IndexedPercentage[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            indexedPercentages[i] = new IndexedPercentage(i, percentages[i]);
        }
        //stable sorting by reverse percentage, ie biggest first
        Arrays.sort(indexedPercentages, new Comparator<IndexedPercentage>() {
            public int compare(IndexedPercentage o1, IndexedPercentage o2) {
                return o2.percentage - o1.percentage;
            }
        });
        //increasing the bonus of the leftover best people by 1
        for (int i = 0; i < leftOver; i++) {
            indexedPercentages[i].percentage++;
        }
        //restore original employee order
        Arrays.sort(indexedPercentages, new Comparator<IndexedPercentage>() {
            public int compare(IndexedPercentage o1, IndexedPercentage o2) {
                return o1.index - o2.index;
            }
        });

        final int[] result = new int[indexedPercentages.length];
        for (int i = 0; i < indexedPercentages.length; i++) {
            result[i] = indexedPercentages[i].percentage;
        }
        return result;
    }

    private static class IndexedPercentage {
        int index;
        int percentage;

        IndexedPercentage(int index, int percentage) {
            this.index = index;
            this.percentage = percentage;
        }
    }
}
