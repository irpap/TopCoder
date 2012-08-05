package div2.medium;

import java.util.HashSet;

public class ColorfulChocolates {

    private HashSet<String> visited;

    public int maximumSpread(String chocolates, int maxSwaps) {
        char[] colors = chocolates.toCharArray();
        visited = new HashSet<String>();
        return findMaxSpread(colors, maxSwaps, 1);

    }

    int findMaxSpread(char[] colors, int maxSwaps, int maxSpread) {
        for (int i = 0; i < colors.length - 1; i++) {
            swap(i, i + 1, colors);
            if (!visited.contains(new String(colors))) {
                visited.add(new String(colors));
                int spread = spread(colors);
                if (spread >= maxSpread) {
                    maxSpread = Math.max(maxSpread, findMaxSpread(colors, maxSwaps - 1, spread));
                }
            }
            swap(i + 1, i, colors);
        }
        return maxSpread;
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