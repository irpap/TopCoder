public class TheBrickTowerMediumDivTwo {

    int smallestDistance = Integer.MAX_VALUE;
    String perm = "AAAAAAA";
    int[] heights;

    public int[] find(int[] heights) {
        int n = heights.length;
        this.heights = heights;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) sb.append(i);
        allPerms(sb.toString(), "");
        System.out.println(perm);
        int[] result = new int[n];
        for (int i = 0; i < perm.length(); i++) {
            result[i] = perm.charAt(i) - '0';
        }
        return result;

    }

    void allPerms(String all, String prefix) {
        int n = all.length();
        if (n == 0) {
            int d = distance(prefix);
            if (d < smallestDistance || d == smallestDistance && perm.compareTo(prefix) > 0) {
                smallestDistance = d;
                perm = prefix;
            }
        }
        for (int i = 0; i < n; i++) {
            allPerms(all.substring(0, i) + all.substring(i + 1), prefix + all.charAt(i));
        }
    }

    private int distance(String order) {
        int total = 0;
        for (int i = 1; i < order.length(); i++) {
            total += Math.abs(heights[order.charAt(i) - '0'] - heights[order.charAt(i - 1) - '0']);
        }
        return total;
    }


}
