// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         int prev=-1;
//         for(int i=0; i<nums.length; i++){
//             if(prev==nums[i]) return true;
//             prev=nums[i];
//         }
//         return false;
//     }
// }


class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> myset = new HashSet<Integer>();
        for(int num:nums)
        {
            myset.add(num);
        }
        return myset.size()<nums.length;
    }
}
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Set<Integer> map = new HashSet<Integer>();
//         for(int num:nums){
//             if(map.contains(num)){
//                 return true;
//             }
//             else map.add(num);
//         }
//         return false;
//     }
// }