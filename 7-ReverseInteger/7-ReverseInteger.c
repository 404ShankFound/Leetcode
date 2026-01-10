// Last updated: 10/01/2026, 16:16:03
1#include <limits.h>
2
3int reverse(int x) {
4    int rev = 0;
5
6    while (x != 0) {
7        int digit = x % 10;
8        x /= 10;
9
10        if (rev > INT_MAX / 10 || 
11           (rev == INT_MAX / 10 && digit > 7))
12            return 0;
13
14        if (rev < INT_MIN / 10 || 
15           (rev == INT_MIN / 10 && digit < -8))
16            return 0;
17
18        rev = rev * 10 + digit;
19    }
20    return rev;
21}
22