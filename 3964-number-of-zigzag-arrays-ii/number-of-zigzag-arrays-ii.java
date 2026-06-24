class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        // state = [up[0..m-1], down[0..m-1]]
        long[] state = new long[2 * m];

        // Length = 2 initialization
        // up[i]   = number of smaller values
        // down[i] = number of larger values
        for (int i = 0; i < m; i++) {
            state[i] = i;
            state[m + i] = m - 1 - i;
        }

        // If n == 2, answer directly
        if (n == 2) {
            long ans = 0;
            for (long x : state)
                ans = (ans + x) % MOD;
            return (int) ans;
        }

        // Transition matrix
        long[][] mat = new long[2 * m][2 * m];

        // newUp[i] = sum down[j], j < i
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                mat[i][m + j] = 1;
            }
        }

        // newDown[i] = sum up[j], j > i
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                mat[m + i][j] = 1;
            }
        }

        // We already have length = 2 state
        long[][] power = matrixPower(mat, n - 2);

        long[] finalState = multiply(power, state);

        long ans = 0;
        for (long x : finalState)
            ans = (ans + x) % MOD;

        return (int) ans;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int sz = mat.length;

        long[][] res = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            res[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = multiply(res, mat);

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] +
                               A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;

                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}