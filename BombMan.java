import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BombMan {
    private static int UNDISCOVERED = 0;
    private static int DISCOVERED = 1;
    private static int FULLY_EXPLORED = 2;

    private char[][] m;
    private int[][] distances;
    private int[][] state;
    private boolean[][] bombed;

    public int shortestPath(String[] maze, int bombs) {
        m = new char[maze.length][maze[0].length()];
        bombed = new boolean[maze.length][maze[0].length()];
        state = new int[maze.length][maze[0].length()];
        distances = new int[maze.length][maze[0].length()];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                m[i][j] = maze[i].charAt(j);
            }
        }

        Point start = findStart(m);

        PriorityQueue<Node> q = new PriorityQueue<Node>(m.length * m[0].length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return distances[o1.p.i][o1.p.j] - distances[o2.p.j][o2.p.j];
            }
        });

        q.add(new Node(start));
        state[start.i][start.j] = DISCOVERED;
        while (!q.isEmpty()) {
            Node top = q.poll();
            System.out.print("\nvisiting (" + top.p.i + "," + top.p.j + ")" + m[top.p.i][top.p.j]);
            System.out.println(" time passed: " + distances[top.p.i][top.p.j] + ", bombs left: " + bombs);
            int topDistance = distances[top.p.i][top.p.j];
            if (isExit(top)) return topDistance;
            boolean usedBomb = false;
            //for each adjacent node
            for (Point neighbor : neighboringPoints(top.p)) {
                System.out.println("\tcoming from  (" + top.p.i + ", " + top.p.j + ") visiting (" + neighbor.i + "," + neighbor.j + ")");
                //if i've never seen it before
                if (state[neighbor.i][neighbor.j] == UNDISCOVERED) {
                    state[neighbor.i][neighbor.j] = DISCOVERED;
                    Node neighborNode = new Node(neighbor);
                    if (m[neighbor.i][neighbor.j] == '#' && bombs > 0) {
                        q.add(neighborNode);
                        distances[neighbor.i][neighbor.j] = topDistance + 3;
                        m[neighbor.i][neighbor.j] = '.';
                        bombed[neighbor.i][neighbor.j] = true;
                        usedBomb = true;
                    } else {
                        q.add(neighborNode);
                        distances[neighbor.i][neighbor.j] = topDistance + 1;
                    }
                }
            }
            if (usedBomb) {
                bombs--;
                usedBomb = false;
            }
            state[top.p.i][top.p.j] = FULLY_EXPLORED;
            //undo bombs effects cause now we went out of this node after fully exploring
            if (bombed[top.p.i][top.p.j]) {
                m[top.p.i][top.p.j] = '.';
                bombs++;
            }
        }
        return -1;
    }

    private List<Point> neighboringPoints(Point p) {
        LinkedList<Point> neighbors = new LinkedList<Point>();
        if (p.i - 1 >= 0) neighbors.add(new Point(p.i - 1, p.j));
        if (p.j - 1 >= 0) neighbors.add(new Point(p.i, p.j - 1));
        if (p.i + 1 < m.length) neighbors.add(new Point(p.i + 1, p.j));
        if (p.j + 1 < m.length) neighbors.add(new Point(p.i, p.j + 1));
        return neighbors;
    }

    private boolean isExit(Node node) {
        return m[node.p.i][node.p.j] == 'E';
    }

    private Point findStart(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 'B') return new Point(i, j);
            }
        }
        return null;
    }

    private static class Node {
        public Point p;

        public Node(Point point) {
            this.p = point;
        }
    }

    private static class Point {
        int i;
        int j;

        private Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
