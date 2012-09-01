import static java.util.Arrays.*;

public class StrangeCountry {

    private int[] redundantCount; //how many redundant edges are there in each component (i.e. that can be removed without disconnecting it). -1 means this is not a component
    private int[] finishTime;
    private int[] entryTime;  //what time we entered each node. Also used as the "seen" array.
    private int time = 0;

    public int transform(String[] g) {
        int n = g.length;
        entryTime = new int[n];
        finishTime = new int[n];
        redundantCount = new int[n];
        initialiseArrays();

        findComponents(g);
        //now the redundant components are double the real value because the graph is undirected and we counted each edge twice
        for (int i = 0; i < n && redundantCount[i] != -1; i++) redundantCount[i] /= 2;

        int operations = 0;

        sort(redundantCount);
        int indexZeroRed = 0;   //index to the first zero-redundant-edges component
        while (redundantCount[indexZeroRed] == -1) indexZeroRed++;
        int indexRed = n - 1;   //index to the last components with redundant edges

        //Connect a component with redundant edges with a component without redundant edges by consuming a redundant edge
        while (redundantCount[indexRed] > 0 && redundantCount[indexZeroRed] == 0) {
            operations++;
            redundantCount[indexRed]--;   //reduce by 1 the number of redundant edges cause we used 1 to connect the two components
            if (redundantCount[indexRed] == 0) indexRed--;
            redundantCount[indexZeroRed] = -1; //this component doesn't exist anymore, it got merged!
            indexZeroRed++;
        }
        //if we are done, return operations made so far. We are done if there is a single component left
        int componentsLeft = 0;
        for (int i = 0; i < n; i++) if (redundantCount[i] != -1) componentsLeft++;
        if (componentsLeft == 1) return operations;

        debug(redundantCount);

        //There are at least two components left and they are either all Zeroes or all NonZeroes. Because if it was a 0 and a nonzero it would have been merged in the previous step
        //if they all have zero redundant edges it's impossible to merge them
        for (int i = 0; i < n; i++) if (redundantCount[i] == 0) return -1;

        //Otherwise they are all >0 redundant edges
        //2 components with redundant edges can be merged by doing 1 operation. For convenience I do half operation per component
        int halfOps = 0;
        for (int i = 0; i < n; i++) {
            if (redundantCount[i] > 0) {
                halfOps++;
            }
        }
        return operations + (halfOps / 2);
    }

    private void initialiseArrays() {
        fill(entryTime, -1);
        fill(finishTime, -1);
        fill(redundantCount, -1);
    }

    private void debug(Object... a) {
        System.out.println(deepToString(a));
    }

    private void findComponents(String[] g) {
        int component = 0;
        for (int i = 0; i < g.length; i++) {
            if (entryTime[i] == -1) dfs(g, i, component++);
        }
    }

    private void dfs(String[] g, int u, int component) {
        entryTime[u] = time++;
        String neighbors = g[u];
        for (int v = 0; v < neighbors.length(); v++) {
            if (neighbors.charAt(v) == 'Y' && entryTime[v] != -1 && finishTime[v] == -1) {
                //v is still in progress - this is a backedge, so there is a cycle
                redundantCount[component]++;
            }
            if (neighbors.charAt(v) == 'Y' && entryTime[v] == -1) {
                dfs(g, v, component);
            }
        }
        finishTime[u] = time++;
    }


}
