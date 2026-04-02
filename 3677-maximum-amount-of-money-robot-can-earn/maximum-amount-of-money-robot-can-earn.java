class Solution {
    int m, n;
    Integer[][][] memo;
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        memo = new Integer[m][n][3];
        return solve(0, 0, 2, coins);
    }
    int solve(int i, int j, int skips, int[][] coins) {
        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (memo[i][j][skips] != null)
            return memo[i][j][skips];

        if (i == m-1 && j == n-1) {
            if (coins[i][j] < 0 && skips > 0)
                return memo[i][j][skips] = 0;
            return memo[i][j][skips] = coins[i][j];
        }

        int best = Math.max(
            solve(i+1, j, skips, coins),
            solve(i, j+1, skips, coins)
        );

        int ans = coins[i][j] + best;

        // try skipping robber
        if (coins[i][j] < 0 && skips > 0) {
            int skipBest = Math.max(
                solve(i+1, j, skips-1, coins),
                solve(i, j+1, skips-1, coins)
            );

            ans = Math.max(ans, skipBest);
        }

        return memo[i][j][skips] = ans;
    }
}