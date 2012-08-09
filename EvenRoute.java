/**
     * SRM 538 DIV I
     */
public class EvenRoute {
    /**
     * We don't need to calculate the path, just to verify its existence. We know that it always starts at (0,0) and it must end at one of the points. So we just need to verify the parity from (0,0) to any of the other points. This works because The parity of the distance from point a to point b is independent of the path taken as there can't be diagonal steps
     */
    public String isItPossible(int[] x, int[] y, int wantedParity) {

        for (int i = 0; i < x.length; i++) {
            final int distanceFromZero = stepsBetweenPoints(new Point(0, 0), new Point(x[i], y[i]));
            if (distanceFromZero % 2 == wantedParity) return "CAN";
        }
        return "CANNOT";
    }

    int stepsBetweenPoints(Point a, Point b) {
        final int xdistance = distance(a.x, b.x);
        final int ydistance = distance(a.y, b.y);
        return xdistance + ydistance;
    }

    private int distance(int a, int b) {
        final int maxX = Math.max(a, b);
        final int minX = Math.min(a, b);
        return Math.abs(maxX - minX);
    }

    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


}
