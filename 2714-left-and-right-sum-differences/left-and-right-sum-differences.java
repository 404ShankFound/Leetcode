// /*
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int leftsum = 0;
        int rightsum = 0;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i]=0;
        }        
        for(int i=0; i<n; i++){
            result[i]+=leftsum;
            leftsum+=nums[i];
        } 
        for(int i=n-1; i>=0; i--){
            result[i]-=rightsum;
            rightsum+=nums[i];
        }               
        for(int i=0; i<n; i++){
            result[i]=Math.abs(result[i]);
        }
        return result;
    }
}
// */

/*
BRUTE FORCE:-
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
*/