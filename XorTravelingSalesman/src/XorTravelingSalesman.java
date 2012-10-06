import java.util.LinkedList;

import static java.lang.Math.max;

public class XorTravelingSalesman {

    public int maxProfit(int[] cityValues, String[] roads) {
        long[] visited = new long[2000];
        int n = cityValues.length;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        LinkedList<Integer> profits = new LinkedList<Integer>();

        int maxProfit = cityValues[0];
        stack.add(0);
        profits.add(cityValues[0]);

        while (!stack.isEmpty()) {
            Integer top = stack.removeFirst();
            Integer profit = profits.removeFirst();
            visited[profit] |= 1<<top;
            maxProfit = max(profit, maxProfit);
            for (int i = 0; i < n; i ++) if (roads[top].charAt(i)=='Y') {
                int nextProfit = profit ^ cityValues[i];
                if ((visited[nextProfit] & 1<<i) == 0) {
                    stack.addFirst(i);
                    profits.addFirst(nextProfit);
                }
            }
        }
        return maxProfit;
    }
}
