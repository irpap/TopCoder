public class BadNeighbors {
    public int maxDonations (int[] donations) {
        final int n = donations.length;
        int[] dp = new int[n];
        dp[0] = donations[0];
        for (int i = 1; i < n; i++) {
            int maxNotNeighborIndex=i;
            for (int j =0; j< n; j++) {
                if (j+1%n!=j && j-1!=j) maxNotNeighborIndex=Math.max(dp[maxNotNeighborIndex], dp[j])
            }
        }
    }
}
