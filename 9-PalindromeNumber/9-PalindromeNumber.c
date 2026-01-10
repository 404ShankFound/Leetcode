// Last updated: 10/01/2026, 16:30:58
1#include <stdbool.h>
2#include <limits.h>
3
4int rev(int x){
5    int r = 0;
6    while(x > 0){
7        int z = x % 10;
8
9        // overflow check
10        if (r > INT_MAX / 10)
11            return -1;
12
13        r = r * 10 + z;
14        x /= 10;
15    }
16    return r;
17}
18
19bool isPalindrome(int x) {
20    if (x < 0)
21        return false;
22
23    int r = rev(x);
24    if (r == -1)
25        return false;
26
27    return x == r;
28}
29