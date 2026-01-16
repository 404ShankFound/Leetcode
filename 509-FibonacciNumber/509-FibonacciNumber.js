// Last updated: 16/01/2026, 23:39:20
1/**
2 * @param {number} n
3 * @return {number}
4 */
5var fib = function(n) {
6    if (n === 0) return 0;
7    if (n === 1) return 1;
8
9    let prev2 = 0; // F(0)
10    let prev1 = 1; // F(1)
11
12    for (let i = 2; i <= n; i++) {
13        let curr = prev1 + prev2;
14        prev2 = prev1;
15        prev1 = curr;
16    }
17
18    return prev1;
19};