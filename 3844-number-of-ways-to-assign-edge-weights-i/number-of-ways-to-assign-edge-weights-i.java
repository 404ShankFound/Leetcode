class Solution {
    static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        // Tree with only root node
        if (n == 1) {
            return 0;
        }

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int maxDepth = 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new int[]{1, 0});   // node, depth
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int node = cur[0];
            int depth = cur[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int nei : graph[node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(new int[]{nei, depth + 1});
                }
            }
        }

        // answer = 2^(maxDepth - 1)
        long ans = 1;
        long base = 2;
        int exp = maxDepth - 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return (int) ans;
    }
}