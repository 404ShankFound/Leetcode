// Last updated: 10/01/2026, 16:13:37
1#include <limits.h>
2int reverse(int x) {
3    int rev = 0;
4    int MAX_DIV_10 = INT_MAX / 10;
5    int MIN_DIV_10 = INT_MIN / 10;
6    int digit = 0;
7
8    while (x != 0) {
9        digit = x % 10;
10        x /= 10;
11        // overflow check
12        if (rev > MAX_DIV_10 || (rev == MAX_DIV_10 && digit > 7))
13            return 0;
14        // underflow check
15        if (rev < MIN_DIV_10 || (rev == MIN_DIV_10 && digit < -8))
16            return 0;
17        rev = rev * 10 + digit;
18    }
19    return rev;
20}
21