import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Single Round Match 233 Round 1 - Division I, Level Two
 * BFS practice
 */
public class SmartWordToy {
    public int minPresses(String start, String finish, String[] forbid) {
        Node.initForbidden(forbid);
        Node s = new Node(start.toCharArray());
        //        System.out.println(s.neighbors());
        return bfs(s, finish);
    }

    private int bfs(Node s, String finish) {
        HashSet<String> visited = new HashSet<String>();

        LinkedList<Node> q = new LinkedList<Node>();
        q.add(s);
        while (q.isEmpty() == false) {
            Node top = q.getFirst();
            q.removeFirst();
            //            System.out.println(top);
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
        public static final char A = 'a';
        int steps = 0;
        static boolean[][][][] forbidden;

        private static void initForbidden(final String[] forbid) {
            boolean[][][][] forbidden = new boolean[26][26][26][26];

            for (String s : forbid) {
                String[] split = s.split(" ");
                for (int i = 0; i < split[0].length(); i++) {
                    for (int j = 0; j < split[1].length(); j++) {
                        for (int k = 0; k < split[2].length(); k++) {
                            for (int l = 0; l < split[3].length(); l++) {
                                forbidden[split[0].charAt(i) - A][split[1].charAt(j) - A][split[2].charAt(k) - A][split[3].charAt(l) - A] = true;
                            }
                        }
                    }
                }
            }


            Node.forbidden = forbidden;
        }

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
                char[] prev = createWordWithNextLetter(i);
                addToNeighborsIfNotForbidden(neighbors, prev);
            }

            for (int i = 0; i < word.length; i++) {
                char[] next = createWordWithPrevLetter(i);

                addToNeighborsIfNotForbidden(neighbors, next);
            }

            return new LinkedList(neighbors);
        }

        private void addToNeighborsIfNotForbidden(HashSet<Node> neighbors, char[] next) {
            if (isForbidden(next) == false) {
                neighbors.add(new Node(next));
            }
        }

        private char[] createWordWithPrevLetter(int i) {
            char[] next = new char[4];

            for (int j = 0; j < word.length; j++) {
                next[j] = (i == j) ? next(word[j]) : word[j];
            }
            return next;
        }

        private char[] createWordWithNextLetter(int i) {
            char[] prev = new char[4];

            for (int j = 0; j < word.length; j++) {
                prev[j] = (i == j) ? prev(word[j]) : word[j];
            }
            return prev;
        }

        private boolean isForbidden(char[] word) {
            return forbidden[word[0] - A][word[1] - A][word[2] - A][word[3] - A];
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
