// Last updated: 22/01/2026, 23:56:08
1class Solution {
2    public boolean check(int[] nums) {
3        int n = nums.length;
4        boolean rotated = false;
5
6        for (int i = 0; i < n; i++) {
7            if (nums[i] > nums[(i + 1) % n]) {
8                if (rotated) return false;
9                rotated = true;
10            }
11        }
12        return true;
13    }
14}
15