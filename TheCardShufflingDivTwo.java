import java.util.LinkedList;

public class TheCardShufflingDivTwo {

    LinkedList<Integer> left = new LinkedList<Integer>();
    LinkedList<Integer> main = new LinkedList<Integer>();
    LinkedList<Integer> right = new LinkedList<Integer>();

    public int shuffle(int n, int m) {
        for (int i = 1; i <= n; i++) {
            main.add(i);
        }
        for (int i = 0; i < m; i++) {
            //step 1
            while (!main.isEmpty()) {
                left.addFirst(main.removeFirst());
                if (!main.isEmpty()) {
                    right.addFirst(main.removeFirst());
                }
            }
            //step 2
            while (!left.isEmpty()) {
                main.addFirst(left.removeFirst());
            }
            //step 3
            while (!right.isEmpty()) {
                main.addFirst(right.removeFirst());
            }
        }
        return main.getFirst();
    }
}