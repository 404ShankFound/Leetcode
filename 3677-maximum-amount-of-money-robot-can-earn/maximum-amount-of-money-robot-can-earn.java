class Solution {
    int m, n;
    Integer[][][] memo;  
    
    // Integer wrapper assumes defaut value null but int will assume zero
    //null means not computed yet whereas using int will by default assume 0 
    //so ambiguous that whether initialised by default or is computed as 0

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


        //current is robber, so skip robber
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