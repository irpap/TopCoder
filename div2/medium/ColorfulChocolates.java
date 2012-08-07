package div2.medium;

import java.util.HashSet;
import java.util.LinkedList;

public class ColorfulChocolates {

    private HashSet<String> visited;

    public int maximumSpread(String chocolates, int maxSwaps) {
        char[] colors = chocolates.toCharArray();
        return findMaxSpread(colors, maxSwaps, 1);

    }

    int findMaxSpread(char[] colors, int maxSwaps, int maxSpread) {
        LinkedList<ChocolateArrangement> queue = new LinkedList<ChocolateArrangement>();
        visited = new HashSet<String>();
        int bestSpread = 0;
        queue.add(new ChocolateArrangement(new String(colors), maxSwaps, spread(colors)));

        while (!queue.isEmpty()) {
            ChocolateArrangement top = queue.pop();
            bestSpread = Math.max(bestSpread, top.spread);
            if (top.swapsLeft==0) continue;
            LinkedList<ChocolateArrangement> neighbors = neighbors(top);
            for (ChocolateArrangement neighbor : neighbors) {
                if (!visited.contains(neighbor.chocolates)) {
                    visited.add(neighbor.chocolates);
                    if (neighbor.spread >= maxSpread) {
                        queue.add(neighbor);
                    }
                }
            }

        }
        return bestSpread;
    }

    private static class ChocolateArrangement {
        String chocolates;
        int swapsLeft;
        int spread;

        private ChocolateArrangement(String chocolates, int swapsLeft, int spread) {
            this.chocolates = chocolates;
            this.swapsLeft = swapsLeft;
            this.spread = spread;
        }
    }

    private LinkedList<ChocolateArrangement> neighbors(ChocolateArrangement c) {
        LinkedList<ChocolateArrangement> neighbors = new LinkedList<ChocolateArrangement>();
        char[] colors = c.chocolates.toCharArray();
        for (int i = 0; i < colors.length - 1; i++) {
            swap(i, i + 1, colors);
            neighbors.add(new ChocolateArrangement(new String(colors), c.swapsLeft - 1, spread(colors)));
            swap(i, i + 1, colors);
        }
        return neighbors;
    }

    private int spread(char[] colors) {
        int max = 0;
        int currentMax = 1;
        for (int i = 0; i < colors.length - 1; i++) {
            if (colors[i + 1] == colors[i]) currentMax++;
            else {
                max = Math.max(max, currentMax);
                currentMax = 1;
            }
        }
        return max;
    }

    private void swap(int i, int j, char[] array) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}