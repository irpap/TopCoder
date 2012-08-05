package div2.easy;

import java.util.HashMap;

/**
 * SRM 546 DIV 2
 */
public class ContestWinner {
    public int getWinner(int[] events) {
        int winner = events[0];
        int winningCount = 1;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int e : events) {
            if (!count.containsKey(e)) count.put(e, 1);
            else {
                int newCount = count.get(e) + 1;
                count.put(e, newCount);
                if (newCount > winningCount) {
                    winner = e;
                    winningCount = newCount;
                }
            }
        }
        return winner;
    }
}
