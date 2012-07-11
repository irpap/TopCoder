/**
 * SRM 546 DIV 2 *
 */
public class TwoRectangles {
    public String describeIntersection(int[] A, int[] B) {
        Point al = new Point(A[0], A[1]);
        Point ar = new Point(A[2], A[3]);
        Point bl = new Point(B[0], B[1]);
        Point br = new Point(B[2], B[3]);

        if (bl.equals(ar)) return "point";

        if (bl.sameY(ar) && br.isRightOf(al) && bl.isLeftOf(ar)) return "segment";

        if (bl.sameX(ar) && br.isNorthOf(al) && bl.isSouthOf(ar)) return "segment";

        if (((bl.sameX(al) || bl.isRightOf(al)) && bl.isLeftOf(ar)) &&
                ((bl.sameY(al) || bl.isNorthOf(al)) && bl.isSouthOf(ar))) return "rectangle";

        return "none";
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        boolean sameX(Point p) {
            return this.x == p.x;
        }

        boolean sameY(Point p) {
            return this.y == p.y;
        }

        boolean isNorthOf(Point p) {
            return this.y > p.y;
        }

        boolean isSouthOf(Point p) {
            return this.y < p.y;
        }

        boolean isRightOf(Point p) {
            return this.x > p.x;
        }

        boolean isLeftOf(Point p) {
            return this.x < p.x;
        }
    }
}
