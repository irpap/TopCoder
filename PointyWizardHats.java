import java.util.Arrays;

/**
 * This problem was used for:
 * Single Round Match 549 Round 1 - Division I, Level One
 * Single Round Match 549 Round 1 - Division II, Level Two
 */
public class PointyWizardHats {
    public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius) {
        Hat[] topHats = new Hat[topHeight.length];
        Hat[] bottomHats = new Hat[bottomHeight.length];

        for (int i = 0; i < topHats.length; i++) {
            topHats[i] = new Hat(topRadius[i], topHeight[i]);
        }
        for (int i = 0; i < bottomHats.length; i++) {
            bottomHats[i] = new Hat(bottomRadius[i], bottomHeight[i]);
        }
        Arrays.sort(topHats);
        Arrays.sort(bottomHats);

        int count = 0;
        int topIndex = 0;
        int bottomIndex = 0;

        while (topIndex < topHats.length && bottomIndex < bottomHats.length) {

            if (topHats[topIndex].compareTo(bottomHats[bottomIndex]) < 0) {
                count++;
                topIndex++;
                bottomIndex++;
            } else {
                bottomIndex++;
            }
        }
        return count;
    }

    private static class Hat implements Comparable {
        int radius;
        int height;

        private Hat(int radius, int height) {
            this.radius = radius;
            this.height = height;
        }

        double angle() {
            return Math.atan2(radius, height);
        }

        /**
         * returns 1 if this can go to the bottom, -1 if this can go to the top, and 0 if nothing can happen
         */
        public int compareTo(Object o) {
            if (this.radius > ((Hat) o).radius && this.angle() - ((Hat) o).angle() > 0.0000001) return 1;
            if (this.radius < ((Hat) o).radius && this.angle() - ((Hat) o).angle() < 0.0000001) return -1;
            return 0;
        }
    }
}
