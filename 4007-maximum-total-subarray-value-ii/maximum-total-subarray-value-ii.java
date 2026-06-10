import java.util.*;

class Solution {

    static class SparseTable {
        int n, log;
        int[][] maxTable;
        int[][] minTable;
        int[] lg;

        SparseTable(int[] nums) {
            n = nums.length;

            lg = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                lg[i] = lg[i / 2] + 1;
            }

            log = lg[n] + 1;

            maxTable = new int[log][n];
            minTable = new int[log][n];

            for (int i = 0; i < n; i++) {
                maxTable[0][i] = nums[i];
                minTable[0][i] = nums[i];
            }

            for (int j = 1; j < log; j++) {
                int len = 1 << j;
                int half = len >> 1;

                for (int i = 0; i + len <= n; i++) {
                    maxTable[j][i] = Math.max(
                            maxTable[j - 1][i],
                            maxTable[j - 1][i + half]
                    );

                    minTable[j][i] = Math.min(
                            minTable[j - 1][i],
                            minTable[j - 1][i + half]
                    );
                }
            }
        }

        int queryMax(int l, int r) {
            int j = lg[r - l + 1];

            return Math.max(
                    maxTable[j][l],
                    maxTable[j][r - (1 << j) + 1]
            );
        }

        int queryMin(int l, int r) {
            int j = lg[r - l + 1];

            return Math.min(
                    minTable[j][l],
                    minTable[j][r - (1 << j) + 1]
            );
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SparseTable st = new SparseTable(nums);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(b[0], a[0])
        );

        // Start with largest value from each sequence
        for (int l = 0; l < n; l++) {
            long val = (long) st.queryMax(l, n - 1)
                    - st.queryMin(l, n - 1);

            pq.offer(new long[]{val, l, n - 1});
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long[] cur = pq.poll();

            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];

            ans += val;

            // Push next element from same sequence
            if (r > l) {
                r--;

                long nextVal = (long) st.queryMax(l, r)
                        - st.queryMin(l, r);

                pq.offer(new long[]{nextVal, l, r});
            }
        }

        return ans;
    }
}