class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n - 1)) == 0;
        // (n>0) FOR Edge cases for 0 = 0.....00 and negative numbers 1.......
    }
}

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
