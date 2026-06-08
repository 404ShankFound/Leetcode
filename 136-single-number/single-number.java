//Using XOR(Bit-Manipulation)
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

/* BRUTE FORCE: BEATS 99.4%
class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }
            else{
                map.put(x, 1);
            }
        }
        for(int x : nums){
            if(map.get(x)==1){
                return x;
            }
        }
        return -1;
    }
}
*/