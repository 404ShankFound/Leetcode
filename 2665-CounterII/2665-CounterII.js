// Last updated: 17/01/2026, 23:41:19
1/**
2 * @param {number} init
3 * @return {{ increment: Function, decrement: Function, reset: Function }}
4 */
5var createCounter = function(init) {
6    let current = init;   // private variable (closure)
7
8    return {
9        increment: function() {
10            return ++current;
11        },
12        decrement: function() {
13            return --current;
14        },
15        reset: function() {
16            current = init;
17            return current;
18        }
19    };
20};
21