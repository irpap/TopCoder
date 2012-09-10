import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TCCC '04 Round 4 - 500
 */
public class BombMan {
    int n, m;
    private boolean[][][] seen;

    public int shortestPath(String[] maze, int bombs) {
        n = maze.length;
        m = maze[0].length();
        seen = new boolean[n][m][bombs + 1];

        Point start = findStart(maze);

        PriorityQueue<Node> q = new PriorityQueue<Node>(n * m * (bombs + 1), new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.timeSpent - o2.timeSpent;
            }
        });
        q.add(new Node(start.x, start.y, maze[start.x].charAt(start.y), bombs, 0));
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (seen[top.pos.x][top.pos.y][top.bombsLeft]) continue;
            seen[top.pos.x][top.pos.y][top.bombsLeft] = true;
            if (top.cellType == 'E') return top.timeSpent;
            for (Point np : neighboringPoints(top.pos)) {
                if (maze[np.x].charAt(np.y) == '#') {
                    if (top.bombsLeft == 0) continue;
                    q.add(new Node(np.x, np.y, maze[np.x].charAt(np.y), top.bombsLeft - 1, top.timeSpent + 3));
                } else
                    q.add(new Node(np.x, np.y, maze[np.x].charAt(np.y), top.bombsLeft, top.timeSpent + 1));
            }
        }
        return -1;
    }

    private List<Point> neighboringPoints(Point p) {
        LinkedList<Point> neighbors = new LinkedList<Point>();
        int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int tx = p.x + dx[i], ty = p.y + dy[i];
            if (tx < 0 || ty < 0 || tx >= n || ty >= m) continue;
            neighbors.add(new Point(tx, ty));
        }
        return neighbors;
    }

    private Point findStart(String[] maze) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i].charAt(j) == 'B') return new Point(i, j);
            }
        }
        return null;
    }

    private static class Node {
        private char cellType;
        private int timeSpent;
        private int bombsLeft;
        private Point pos;

        public Node(int x, int y, char type, int bombs, int time) {
            this.pos = new Point(x, y);
            this.bombsLeft = bombs;
            this.cellType = type;
            this.timeSpent = time;
        }
    }

    private static class Point {
        int x, y;
        private Point(int x, int y) { this.x = x; this.y = y; }
    }
}
