
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int leftsum = 1;
        int rightsum = 1;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i]=1;
        }        
        for(int i=0; i<n; i++){
            result[i]*=leftsum;
            leftsum*=nums[i];
        } 
        for(int i=n-1; i>=0; i--){
            result[i]*=rightsum;
            rightsum*=nums[i];
        }               
        return result;
    }
}


/* BRUTE FORCE: TLE
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        for(int i=0; i<n; i++){
            result[i]=1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                result[i]*=nums[j];
            }
            for(int j=i+1; j<n; j++){
                result[i]*=nums[j];
            }
        }
        return result;
    }
}
*/
