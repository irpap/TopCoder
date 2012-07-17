import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Single Round Match 233 Round 1 - Division I, Level Two
 * BFS practice
 */
public class SmartWordToy {
    public int minPresses(String start, String finish, String[] forbid) {
        Node.forbid = forbid;
        Node s = new Node(start.toCharArray());
        return bfs(s, finish);
    }

    private int bfs(Node s, String finish) {
        HashSet<String> visited = new HashSet<String>();

        LinkedList<Node> q = new LinkedList<Node>();
        q.add(s);
        while (q.isEmpty() == false) {
            Node top = q.getFirst();
            q.removeFirst();
            visited.add(top.toString());
            if (top.toString().equals(finish)) return top.steps;
            for (Node neighbor : top.neighbors()) {
                if (!visited.contains(neighbor.toString())) {
                    neighbor.steps = top.steps + 1;
                    q.add(neighbor);
                }
            }
        }
        return -1;
    }

    static class Node {
        static String[] forbid;
        int steps = 0;

        Node(char[] word) {
            this.word = word;
        }

        char[] word = new char[4];

        public String toString() {
            return new String(word);
        }

        List<Node> neighbors() {

            HashSet<Node> neighbors = new HashSet<Node>();

            for (int i = 0; i < word.length; i++) {
                char[] prev = new char[4];

                for (int j = 0; j < word.length; j++) {
                    prev[j] = (i == j) ? prev(word[j]) : word[j];
                }
                if (forbidden(prev, forbid) == false) {
                    neighbors.add(new Node(prev));
                }
            }

            for (int i = 0; i < word.length; i++) {
                char[] next = new char[4];

                for (int j = 0; j < word.length; j++) {
                    next[j] = (i == j) ? next(word[j]) : word[j];
                }

                if (forbidden(next, forbid) == false) {
                    neighbors.add(new Node(next));
                }

            }

            return new LinkedList(neighbors);
        }

        private boolean forbidden(char[] word, String[] forbid) {
            for (String constraint : forbid) {
                String[] constraints = constraint.split(" ");
                if (constraints[0].contains(word[0] + "") && constraints[1].contains(word[1] + "") && constraints[2].contains(word[2] + "") && constraints[3].contains(word[3] + ""))
                    return true;

            }
            return false;
        }

        private char next(char c) {
            if (c == 'z') return 'a';
            return (char) (c + 1);
        }

        private char prev(char c) {
            if (c == 'a') return 'z';
            return (char) (c - 1);
        }
    }
}
