class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = 0, j = n - 1; i < n; i++, j--) {

            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }

            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }
        }

        while (left <= right) {
            ans[left++] = pivot;
        }

        return ans;
    }
}

/*BRUTE FORCE:
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
*/