import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Build prefix sums after transformation
        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        // Step 2: Coordinate compression
        int[] sorted = pref.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;
        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, idx++);
            }
        }

        // Step 3: Count pairs using Fenwick Tree
        Fenwick bit = new Fenwick(rank.size());
        long ans = 0;

        for (int p : pref) {
            int r = rank.get(p);

            // Count previous prefix sums smaller than current
            ans += bit.query(r - 1);

            // Add current prefix sum
            bit.update(r, 1);
        }

        return ans;
    }
}