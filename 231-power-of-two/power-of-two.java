class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while(n % 2 == 0) {
    n /= 2;
}
return n == 1;
        // (n>0) FOR Edge cases for 0 = 0.....00 and negative numbers 1.......
    }
}

//return n > 0 && Integer.bitCount(n) == 1; (SAME AS ABOVE)

/*
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        double x = Math.log(n) / Math.log(2);
        return Math.abs(x - Math.round(x)) < 1e-10; 
        // 1e-10 For edge case of handling Math.log(536870912)/Math.log(2);
    } 
}
*/

/*BRUTE FORCE : TLE
while(n % 2 == 0) {
    n /= 2;
}
return n == 1;
*/