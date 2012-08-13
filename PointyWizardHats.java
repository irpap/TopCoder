import java.util.Arrays;

/**
 * This problem was used for:
 * Single Round Match 549 Round 1 - Division I, Level One
 * Single Round Match 549 Round 1 - Division II, Level Two
 */
public class PointyWizardHats {
    //size of tophats - Left side
    private int m;
    //size of bottomhats - Right side
    private int n;
    private boolean[][] graph;
    boolean seen[];
    //What left vertex i is matched to (or -1 if unmatched)
    int matchL[];
    //What right vertex j is matched to (or -1 if unmatched)
    int matchR[];

    public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius) {
        m = topHeight.length;
        n = bottomHeight.length;
        graph = new boolean[m][n];
        for (int i = 0; i < topHeight.length; i++) {
            for (int j = 0; j < bottomHeight.length; j++) {
                graph[i][j] = bottomRadius[j] > topRadius[i] && (bottomRadius[j] * topHeight[i] > topRadius[i] * bottomRadius[j]);
            }
        }
        seen = new boolean[n];
        matchL = new int[m];
        Arrays.fill(matchL, -1);
        matchR = new int[n];
        Arrays.fill(matchR, -1);

        int count = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen, false);
            if (bpm(i)) count++;
        }
        return count;
    }

    boolean bpm(int u) {
        //try to match with all vertices on right side
        for (int v = 0; v < n; v++) {
            if (!graph[u][v]) return false;
            if (seen[v]) continue;
            seen[v] = true;
            //match u and v, if v is unassigned, or if v's match on the left side can be reassigned
            if (matchR[v] < 0 || bpm(matchR[v])) {
                matchL[u] = v;
                matchR[v] = u;
                return true;
            }
        }
        return false;
    }
}