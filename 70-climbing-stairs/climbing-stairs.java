//MEMOIZATION USING HELPER FUNCTION
class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 3) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }
}

/*BRUTE FORCE:
failed at n=45, at n=44 output was 1134903170
So the shift by one isn't some deep property of stairs. It's simply because:

Fibonacci is conventionally defined with
Fib(0)=0,Fib(1)=1,
while the natural DP for climbing stairs has
f(0)=1,f(1)=1

Ways: 1 2 3 5 8 ...
Fib : 1 1 2 3 5 8 ...

class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        else return climbStairs(n-1)+climbStairs(n-2);
    }
}
*/