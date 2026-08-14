class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            ans = ans | ((n << (31 - i)) & (1 << (31 - i)));
            n=n>>>1;
        }
        return ans;
    }
}

/*
>> preserves the sign bit.
For example, if:
n = 10000000000000000000000000000000
then:
n >> 1
= 11000000000000000000000000000000
*/