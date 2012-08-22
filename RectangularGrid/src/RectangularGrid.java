/** SRM 146 DIV 1 */
public class RectangularGrid {
    public long countRectangles (int width, int height) {
        long count = 0;
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                if (i == j) { continue; }
                //ixj is all the rectangle sizes we'll try
                //                System.out.println("(x,y) = (" + i + ", " + j + ")");
                long fits = howManyTimesItFits(i, j, width, height);
                //                System.out.println("fits " + fits + " times");
                count += fits;
            }
        }
        return count;
    }

    private long howManyTimesItFits (final int x, final int y, final int width, final int height) {
        return (width - x + 1) * (height - y + 1);
    }
}
