/** SRM 146 DIV 1 */
public class RectangularGrid {
    public long countRectangles (int width, int height) {
        long count = 0;
        for (int i = 1; i <= Math.min(width, height); i++) {
            for (int j = i + 1; j <= Math.max(width, height); j++) {
                //ixj is all the rectangle sizes we'll try
                System.out.println("(x,y) = (" + i + ", " + j + ")");
                long fits = howManyTimesItFits(i, j, width, height);
                System.out.println("fits " + fits + " times");
                count += fits;
            }
        }
        System.out.println(count);
        return count;
    }

    private long howManyTimesItFits (final int x, final int y, final int width, final int height) {
        long count = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (fitsAt(i, j, x, y, width, height)) { count++; }
                if (fitsAt(i, j, y, x, width, height)) { count++; }
            }
        }
        return count;
    }

    private boolean fitsAt (final int i, final int j, final int x, final int y, final int width, final int height) {
        return i + x <= width && j + y <= height;
    }
}
