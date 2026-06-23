class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int v = 0; v < m; v++) {
            up[v] = v;               // smaller values
            down[v] = m - 1 - v;     // larger values
        }

        // Build lengths 3 ... n
        for (int len = 3; len <= n; len++) {

            long[] prefUp = new long[m];
            long[] prefDown = new long[m];

            prefUp[0] = up[0];
            prefDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int x = 0; x < m; x++) {

                // previous value y < x, previous move was down
                if (x > 0)
                    newUp[x] = prefDown[x - 1];

                // previous value y > x, previous move was up
                long totalUp = prefUp[m - 1];
                long uptoX = prefUp[x];
                newDown[x] = (totalUp - uptoX + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}