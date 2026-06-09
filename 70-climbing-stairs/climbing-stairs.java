//MEMOIZATION USING HELPER FUNCTION
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};

        int power = n;

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiply(result, base);
            }

            base = multiply(base, base);
            power >>= 1;
        }

        return (int) result[0][0];   // Fib(n+1)
    }

    private long[][] multiply(long[][] a, long[][] b) {
        return new long[][] {
            {
                a[0][0] * b[0][0] + a[0][1] * b[1][0],
                a[0][0] * b[0][1] + a[0][1] * b[1][1]
            },
            {
                a[1][0] * b[0][0] + a[1][1] * b[1][0],
                a[1][0] * b[0][1] + a[1][1] * b[1][1]
            }
        };
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