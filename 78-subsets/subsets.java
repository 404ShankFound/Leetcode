import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        int limit = 1 << n;

        List<List<Integer>> ans = new ArrayList<>(limit);

        for (int mask = 0; mask < limit; mask++) {

            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            ans.add(subset);
        }

        return ans;
    }
}