class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        // Multi-source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                if (dist[nr][nc] != -1)
                    continue;

                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (vis[r][c])
                continue;

            vis[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return safe;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                if (vis[nr][nc])
                    continue;

                int newSafe = Math.min(safe, dist[nr][nc]);

                pq.offer(new int[]{newSafe, nr, nc});
            }
        }

        return 0;
    }
}