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
        int lub=lt;
        int eub=lt+eq;
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i]<pivot) {arr[lub-lt]=nums[i]; lt--;}
            else if(nums[i]==pivot) {arr[eub-eq]=nums[i]; eq--;}
            else {arr[n-gt]=nums[i]; gt--;}
        }
        return arr;
    }
}