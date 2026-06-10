import java.util.*;

class Solution {

    static class SegmentTree {
        int n;
        int[] maxTree;
        int[] minTree;

        SegmentTree(int[] nums) {
            n = nums.length;
            maxTree = new int[4 * n];
            minTree = new int[4 * n];
            build(1, 0, n - 1, nums);
        }

        private void build(int node, int start, int end, int[] nums) {
            if (start == end) {
                maxTree[node] = nums[start];
                minTree[node] = nums[start];
                return;
            }

            int mid = start + (end - start) / 2;

            build(node * 2, start, mid, nums);
            build(node * 2 + 1, mid + 1, end, nums);

            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }

        int queryMax(int left, int right) {
            return queryMax(1, 0, n - 1, left, right);
        }

        private int queryMax(int node, int start, int end, int left, int right) {
            if (right < start || end < left) {
                return Integer.MIN_VALUE;
            }

            if (left <= start && end <= right) {
                return maxTree[node];
            }

            int mid = start + (end - start) / 2;

            return Math.max(
                    queryMax(node * 2, start, mid, left, right),
                    queryMax(node * 2 + 1, mid + 1, end, left, right)
            );
        }

        int queryMin(int left, int right) {
            return queryMin(1, 0, n - 1, left, right);
        }

        private int queryMin(int node, int start, int end, int left, int right) {
            if (right < start || end < left) {
                return Integer.MAX_VALUE;
            }

            if (left <= start && end <= right) {
                return minTree[node];
            }

            int mid = start + (end - start) / 2;

            return Math.min(
                    queryMin(node * 2, start, mid, left, right),
                    queryMin(node * 2 + 1, mid + 1, end, left, right)
            );
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentTree st = new SegmentTree(nums);

        // {value, l, r}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(b[0], a[0])
        );

        // Largest element of each sequence
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

            // Push next value from the same sequence
            if (r > l) {
                int nextR = r - 1;

                long nextVal = (long) st.queryMax(l, nextR)
                        - st.queryMin(l, nextR);

                pq.offer(new long[]{nextVal, l, nextR});
            }
        }

        return ans;
    }
}