// Last updated: 10/01/2026, 16:14:09
1#include <limits.h>
2int reverse(int x) {
3    int rev = 0;
4    int MAX_DIV_10 = INT_MAX / 10;
5    int MIN_DIV_10 = INT_MIN / 10;
6
7    while (x != 0) {
8        int digit = x % 10;
9        x /= 10;
10        // overflow check
11        if (rev > MAX_DIV_10 || (rev == MAX_DIV_10 && digit > 7))
12            return 0;
13        // underflow check
14        if (rev < MIN_DIV_10 || (rev == MIN_DIV_10 && digit < -8))
15            return 0;
16        rev = rev * 10 + digit;
17    }
18    return rev;
19}
20