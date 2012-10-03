import java.util.LinkedList;

import static java.lang.Math.max;

public class XorTravelingSalesman {

    public int maxProfit(int[] cityValues, String[] roads) {
        boolean[][] visited = new boolean[60][2000];
        int n = cityValues.length;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        LinkedList<Integer> profits = new LinkedList<Integer>();

        int maxProfit = cityValues[0];
        stack.add(0);
        profits.add(cityValues[0]);

        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            Integer profit = profits.pop();
            visited[top][profit] = true;
            maxProfit = max(profit, maxProfit);
            for (int i = 0; i < n; i ++) if (roads[top].charAt(i)=='Y') {
                int nextProfit = profit ^ cityValues[i];
                if (!visited[i][nextProfit]) {
                    stack.push(i);
                    profits.push(nextProfit);
                }
            }
        }
        return maxProfit;
    }
}
