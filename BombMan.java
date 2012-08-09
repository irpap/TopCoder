import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TCCC '04 Round 4 - 500
 */
public class BombMan {
    private static int UNDISCOVERED = 0;
    private static int DISCOVERED = 1;
    private Node[][] nodes;

    public int shortestPath(String[] maze, int bombs) {
        nodes = new Node[maze.length][maze[0].length()];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                nodes[i][j] = new Node(new Point(i, j), maze[i].charAt(j));
            }
        }

        Point start = findStart(nodes);

        PriorityQueue<Node> q = new PriorityQueue<Node>(nodes.length * nodes[0].length, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return nodes[o1.p.i][o1.p.j].timeSpent - nodes[o2.p.j][o2.p.j].timeSpent;
            }
        });

        q.add(new Node(start, nodes[start.i][start.j].m));
        nodes[start.i][start.j].state = DISCOVERED;
        nodes[start.i][start.j].bombsLeft = bombs;
        while (!q.isEmpty()) {
            Node top = q.poll();
            int topDistance = nodes[top.p.i][top.p.j].timeSpent;
            if (isExit(top)) return topDistance;
            for (Point neighbor : neighboringPoints(top.p)) {
                if (nodes[neighbor.i][neighbor.j].state == UNDISCOVERED) {
                    nodes[neighbor.i][neighbor.j].state = DISCOVERED;
                    Node neighborNode = new Node(neighbor, nodes[neighbor.i][neighbor.j].m);
                    q.add(neighborNode);
                    if (nodes[neighbor.i][neighbor.j].m == '#' && nodes[top.p.i][top.p.j].bombsLeft > 0) {
                        nodes[neighbor.i][neighbor.j].bombsLeft = nodes[top.p.i][top.p.j].bombsLeft - 1;
                        nodes[neighbor.i][neighbor.j].timeSpent = topDistance + 3;
                    } else {
                        nodes[neighbor.i][neighbor.j].timeSpent = topDistance + 1;
                        nodes[neighbor.i][neighbor.j].bombsLeft = nodes[top.p.i][top.p.j].bombsLeft;
                    }
                }
            }
        }
        return -1;
    }

    private List<Point> neighboringPoints(Point p) {
        LinkedList<Point> neighbors = new LinkedList<Point>();
        if (p.i - 1 >= 0) neighbors.add(new Point(p.i - 1, p.j));
        if (p.j - 1 >= 0) neighbors.add(new Point(p.i, p.j - 1));
        if (p.i + 1 < nodes.length) neighbors.add(new Point(p.i + 1, p.j));
        if (p.j + 1 < nodes.length) neighbors.add(new Point(p.i, p.j + 1));
        return neighbors;
    }

    private boolean isExit(Node node) {
        return nodes[node.p.i][node.p.j].m == 'E';
    }

    private Point findStart(Node[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (nodes[i][j].m == 'B') return new Point(i, j);
            }
        }
        return null;
    }

    private static class Node {
        private char m;
        private int timeSpent;
        private int state;
        private int bombsLeft;

        public Point p;

        public Node(Point point, char m) {
            this.p = point;
            this.m = m;
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
