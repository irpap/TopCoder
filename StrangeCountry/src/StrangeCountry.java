import java.util.Arrays;

public class StrangeCountry {

    private int n;
    private boolean[] seen;
    private int[] whichComponent; //for each node, which connected components does it belong to

    public int transform(String[] g) {
        n = g.length;
        seen = new boolean[n];
        whichComponent = new int[n];
        Arrays.fill(whichComponent, -1);
        findComponents(g);
        debug(seen);
        debug(whichComponent);
        return 0;
    }

    private void debug(Object... a) {
        System.out.println(Arrays.deepToString(a));
    }

    private void findComponents(String[] g) {
        int component = 0;
        for (int i = 0; i < g.length; i++) {
            if (!seen[i]) dfs(g, i, component++);
        }
    }

    private void dfs(String[] g, int u, int component) {
        seen[u] = true;
        whichComponent[u] = component;
        String neighbors = g[u];
        for (int v = 0; v < neighbors.length(); v++) {
            if (neighbors.charAt(v) == 'Y' && !seen[v]) {
                whichComponent[v] = component;
                dfs(g, v, component);
            }
        }
    }
}
