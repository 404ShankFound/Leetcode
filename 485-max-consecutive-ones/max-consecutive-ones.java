// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int max=0;
//         int count=0;
//         int n = nums.length;
//         for(int i=0; i<n; i++){
//             if(nums[i]==1){
//                 count++;
//             }
//             else{
//                 if(count>max){
//                     max=count;
//                 }
//                 count=0;
//             }
//         }
//         return Math.max(max,count);
//     }
// }
class Solution {
    // Function to find maximum consecutive 1's in an array
    public int findMaxConsecutiveOnes(int[] nums) {
        // Variable to store current count of consecutive 1's
        int cnt = 0;
        // Variable to store maximum consecutive 1's
        int maxi = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If current element is 1, increment count
            if (nums[i] == 1) {
                cnt++;
            } else {
                // If element is 0, reset count
                cnt = 0;
            }

            // Update maximum if current count is greater
            maxi = Math.max(maxi, cnt);
        }

        // Return maximum consecutive 1's
        return maxi;
    }
}
