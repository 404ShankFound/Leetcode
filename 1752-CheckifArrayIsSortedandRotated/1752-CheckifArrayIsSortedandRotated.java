// Last updated: 22/01/2026, 23:53:56
1class Solution {
2    public boolean check(int[] nums) {
3        int count = 0;
4        int n = nums.length;
5
6        for (int i = 0; i < n; i++) {
7            if (nums[i] > nums[(i + 1) % n]) {
8                count++;
9            }
10            if (count > 1) {
11                return false;
12            }
13        }
14        return true;
15    }
16}
17