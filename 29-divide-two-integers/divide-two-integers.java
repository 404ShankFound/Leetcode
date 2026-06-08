class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int ans = 0;

        for (int i = 31; i >= 0; i--) {

            if ((dvs << i) <= dvd) {
                dvd -= (dvs << i);
                ans += (1 << i);
            }
        }

        return ((dividend < 0) ^ (divisor < 0))
                ? -ans
                : ans;
    }
}
// class Solution {
//     public int divide(int dividend, int divisor) {

//         // Overflow case
//         if (dividend == Integer.MIN_VALUE && divisor == -1) {
//             return Integer.MAX_VALUE;
//         }

//         // Determine sign
//         boolean positive =
//                 (dividend >= 0 && divisor >= 0) ||
//                 (dividend < 0 && divisor < 0);

//         //positive = (divi >= 0) == (d >= 0);

//         long dvd = Math.abs((long) dividend);
//         long dvs = Math.abs((long) divisor);

//         int ans = 0;

//         while (dvd >= dvs) {

//             long temp = dvs;
//             int multiple = 1;

//             while ((temp << 1) <= dvd) {
//                 temp <<= 1;
//                 multiple <<= 1;
//             }

//             dvd -= temp;
//             ans += multiple;
//         }

//         return positive ? ans : -ans;
//     }
// }