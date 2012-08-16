import java.util.Arrays;

/** Single Round Match 549 Round 1 - Division II, Level Three */
public class OrderOfTheHats {

    int[] adjMask = new int[20]; //Like an adjacency matrix but with bits instead of ints

    //For each of the 2^20 sets of vertices, what is the smallest number of edges that need to be deleted to acquire an acyclic ordering?
    //Each index to dp[] represents a (possibly invalid) topological ordering. A 1 bit at a position in the ordering means that the vertex at that index has a "reverse" edge to an earlier vertex.
    //A 0 bit at an index means that that vertex doesn't have any "reverse" edges.
    //The values of the array are the minimum number of edges that need to be deleted to get an acyclic ordering, for each ordering
    int[] dp = new int[1 << 20];
    int n;

    public int minChanged (String[] spellChart) {
        n = spellChart.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (spellChart[i].charAt(j) == 'Y') { adjMask[i] |= 1 << j; }
            }
        }
        Arrays.fill(dp, Integer.MAX_VALUE);

        return createMinNumberOfEdges(0);
    }

    /**
     * @param mask The subset of vertices that has been topologically sorted among themselves. <p/> If mask[i] == 1 it
     *             means this vertex has been topologically sorted, mask[i] == 0 means it hasn't. At the first call of
     *             the function all bits are set to zero. At every call of the function a new vertex is topologically
     *             sorted, and we continue until all the bits are eventually 1. Every time we sort a vertex, we
     *             calculate how many reverse edges are created as a result, and choose the minimum number of reverse
     *             edges possible. This ensures that we will have to delete the minimum number of edges in order to
     *             achieve a valid topological ordering.
     * @return The minimum number of reverse edges that will be created to sort the 0 bits of the mask parameter
     */
    private int createMinNumberOfEdges (int mask) {
        //if the N LS bits are 1 we are done. It means we sorted all vertices
        if (Integer.bitCount(mask) == n) {
            return 0;
        }
        int numberOfEdgesToDelete = dp[mask]; //minimum number of edges to be deleted
        for (int i = 0; i < n; i++) {
            if (!isSet(mask, i)) {     //if the ith vertex is not already sorted
                int nextMask = mask | (1 << i);
                // can we achieve a smaller number of edges than the one we have stored in dp[i]?
                // The minimum number of edges that we need to delete to make the current ordering acyclic  is either what is stored in dp[i]
                // or the number of edges needed for sorting one more vertex plus the number of vertices that have a reverse edge from vertex i-1
                numberOfEdgesToDelete = Math.min(numberOfEdgesToDelete, Integer.bitCount(nextMask & adjMask[i]) + createMinNumberOfEdges(nextMask));
                dp[mask] = numberOfEdgesToDelete;
            }
        }
        return numberOfEdgesToDelete;
    }

    private boolean isSet (int mask, int i) {
        return (mask & (1 << i)) != 0;
    }
}
