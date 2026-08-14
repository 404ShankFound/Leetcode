class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            int x = n;
            ans = ans | ((x << (31 - i)) & (1 << (31 - i)));
            n=n>>1;
        }
        return ans;
    }
}