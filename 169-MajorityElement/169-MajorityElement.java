// Last updated: 21/01/2026, 18:46:15
1class Solution {
2    public int majorityElement(int[] nums) {
3        int n=nums.length;
4        double y=Math.floor(n/2);
5        for(int i=0; i<n; i++){
6            int count =0;
7            for(int j=0; j<n; j++){
8                if (nums[i]==nums[j])
9                    count++;
10            }
11            if (count>y)
12                return nums[i];
13        }
14        return -1;
15    }
16}