import java.util.HashSet;

public class AvoidRoads {
    public long numWays(int width, int height, String[] bad) {
        HashSet<Edge> badEdges = new HashSet<Edge>();
        for (String b : bad) {
            String[] coords = b.split(" ");
            Point pointA = new Point(new Integer(coords[0]) + 1, new Integer(coords[1]) + 1);
            Point pointB = new Point(new Integer(coords[2]) + 1, new Integer(coords[3]) + 1);
            badEdges.add(new Edge(pointA, pointB));
            badEdges.add(new Edge(pointB, pointA));
        }
        //One extra row & column with zeros so that I don't have to check for out-of-border cases
        long[][] grid = new long[width + 2][height + 2];
        grid[1][1] = 1;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (i == 1 && j == 1) continue;  //don't wanna destroy my seed
                long fromLeft = (badEdges.contains(new Edge(new Point(i - 1, j), new Point(i, j)))) ? 0 : grid[i - 1][j];
                long fromDown = (badEdges.contains(new Edge(new Point(i, j - 1), new Point(i, j)))) ? 0 : grid[i][j - 1];
                grid[i][j] = fromLeft + fromDown;
            }
        }
        return grid[width + 1][height + 1];
    }

    private static class Edge {
        Point x, y;

        public Edge(Point x, Point y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (x != null ? !x.equals(edge.x) : edge.x != null) return false;
            if (y != null ? !y.equals(edge.y) : edge.y != null) return false;

            return true;
        }

        public int hashCode() {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }
    }

    public static class Point {
        int a, b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
//
        public boolean equals(Object another) {
            return ((Point) another).a == a && ((Point) another).b == b;
        }
    }
}
