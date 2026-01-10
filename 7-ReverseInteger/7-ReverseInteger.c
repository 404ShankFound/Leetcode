// Last updated: 10/01/2026, 15:58:27
1#include <limits.h>
2
3int reverse(int x) {
4    int rev = 0;
5
6    while (x != 0) {
7        int digit = x % 10;
8        x /= 10;
9
10        // OVERFLOW CHECK
11        if (rev > INT_MAX / 10 || 
12           (rev == INT_MAX / 10 && digit > 7))
13            return 0;
14
15        // UNDERFLOW CHECK
16        if (rev < INT_MIN / 10 || 
17           (rev == INT_MIN / 10 && digit < -8))
18            return 0;
19
20        rev = rev * 10 + digit;
21    }
22
23    return rev;
24}
25