class Solution {

    static final int MOD = 1_000_000_007;
    static final int LOG = 17;

    List<Integer>[] graph;
    int[][] up;
    int[] depth;
    int[] pow;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        bfs(n);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        pow = new int[n];

        pow[0] = 1;

        for (int i = 1; i < n; i++) {
            pow[i] = (int)((pow[i - 1] * 2L) % MOD);
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            if (dist == 0) {
                ans[i] = 0;
            } else {
                ans[i] = pow[dist - 1];
            }
        }

        return ans;
    }

    private void bfs(int n) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int nei : graph[node]) {

                if (visited[nei]) {
                    continue;
                }

                visited[nei] = true;

                depth[nei] = depth[node] + 1;
                up[nei][0] = node;

                q.offer(nei);
            }
        }
    }

    private int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {

            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}