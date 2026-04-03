class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean rotated = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                if (rotated) return false;
                rotated = true;
            }
        }
        return true;
    }
}
