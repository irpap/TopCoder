public class KingdomAndTrees {

    private int[] heights;

    public int minLevel(int[] heights) {
        this.heights = heights;
        int low = 0;
        int high = Math.max(heights.length, range(heights));
        return search(low, high);
    }

    private int range(int[] heights) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int h : heights) {
            if (h < min) min = h;
            if (h > max) max = h;
        }
        return max - min;
    }

    int search(int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isEnough(mid, heights)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;    // the least level that is enough
    }

    private boolean isEnough(int level, int[] heights) {
        return true;
    }
}
