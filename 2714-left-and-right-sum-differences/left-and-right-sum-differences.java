// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int n = nums.length;
//         left sum = 0;
//         right sum = 0;
//         for(int i=0; i<n; i++){
            
//         }
//         Math.abs(right-left);
//     }
// }

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                result[i]+=nums[j];
            }
            for(int j=i+1; j<n; j++){
                result[i]-=nums[j];
            }
            result[i]=Math.abs(result[i]);
        }
        return result;
    }
}