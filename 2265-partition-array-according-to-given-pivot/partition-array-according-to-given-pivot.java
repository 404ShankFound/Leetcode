class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int lt=0;
        int gt=0;
        int eq=0;
        for(int i=0; i<n; i++){
            if(nums[i]<pivot) lt++;
            else if(nums[i]==pivot) eq++;
            else gt++;
        }
        int less = 0;
        int equal = lt;
        int greater = lt + eq;
        int arr[] = new int[n];
        for(int x : nums){
            if(x < pivot) arr[less++] = x;
            else if(x == pivot) arr[equal++] = x;
            else arr[greater++] = x;
        }
        return arr;
    }
}