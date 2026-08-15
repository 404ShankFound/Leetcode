class Solution {
    public String baseNeg2(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int rem = n & 1;
            sb.append(rem);
            n = (n - rem) / -2;
        }

        return sb.reverse().toString();
    }
}