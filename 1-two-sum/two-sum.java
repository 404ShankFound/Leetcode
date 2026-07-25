// O(n) Time complexity but Space complexity is also O(n) 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int complement=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
// This solution is not valid when any one of the elements has duplicate occurrence
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int x=0;
//         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//         for(int i=0; i<nums.length; i++){
//             map.put(nums[i],i);
//         }
//         for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//             x=entry.getKey();
//             if(map.containsKey(target-x)){
//                 if()
//                 return new int[]{entry.getValue(),map.get(target-x)};
//             }
//         }
//         return new int[]{0,0};
//     }
// }