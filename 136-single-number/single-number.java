class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int i;
        int xord=0;
        for(i=0; i<n; i++){
            xord=xord ^ nums[i];
        }
        return xord;
    }
}