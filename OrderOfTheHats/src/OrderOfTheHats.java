import java.util.Arrays;

import static java.lang.Integer.*;
import static java.lang.Math.*;

/**
 * Single Round Match 549 Round 1 - Division II, Level Three
 */
public class OrderOfTheHats {

    int[] adjMask = new int[20]; //Like an adjacency matrix but with bits instead of ints

    //For each of the 2^20 sets of vertices, what is the smallest number of edges that need to be deleted to acquire an acyclic ordering?
    //Each index to dp[] represents a (possibly invalid) topological ordering. A 1 bit at a position in the ordering means that the vertex at that index has a "reverse" edge to an earlier vertex.
    //A 0 bit at an index means that that vertex doesn't have any "reverse" edges.
    //The values of the array are the minimum number of edges that need to be deleted to get an acyclic ordering, for each ordering
    int[] dp = new int[1 << 20];
    int n;

    public int minChanged(String[] spellChart) {
        n = spellChart.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (spellChart[i].charAt(j) == 'Y') {
                    adjMask[i] |= 1 << j;
                }
            }
        }
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                int min = min(dp[i | 1 << j], dp[i] + bitCount(adjMask[j]) - bitCount(i & adjMask[j]));
                dp[i | 1 << j] = min;
            }
        }
        return dp[(1 << n) - 1];
    }
}
