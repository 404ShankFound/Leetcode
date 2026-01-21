// Last updated: 21/01/2026, 18:39:28
1class Solution {
2    public int majorityElement(int[] nums) {
3        int n=nums.length;
4        for(int i=0; i<n; i++){
5            int count =0;
6            for(int j=0; j<n; j++){
7                if (nums[i]==nums[j])
8                    count++;
9            }
10            if (count>(n/2))
11                return nums[i];
12        }
13        return -1;
14    }
15}