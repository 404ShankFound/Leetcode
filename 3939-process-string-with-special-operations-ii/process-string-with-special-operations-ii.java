class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n];
        long cur = 0;
        long LIMIT = (long) 1e18;

        // Forward pass: store length after each operation
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if ('a' <= c && c <= 'z') {
                cur++;
            }
            else if (c == '*') {
                if (cur > 0) cur--;
            }
            else if (c == '#') {
                cur = Math.min(cur * 2, LIMIT);
            }
            // '%' does not change length

            len[i] = cur;
        }

        // kth character does not exist
        if (k >= cur) {
            return '.';
        }

        // Backward pass
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            long after = len[i];
            long before = (i == 0) ? 0 : len[i - 1];

            if ('a' <= c && c <= 'z') {

                // This letter was appended at position 'before'
                if (k == before) {
                    return c;
                }

            }
            else if (c == '*') {

                // Forward:
                // before -> after
                // length decreases by 1 if before > 0
                // The tracked k remains unchanged.

            }
            else if (c == '#') {

                // Forward: before -> before + before
                if (k >= before) {
                    k -= before;
                }

            }
            else if (c == '%') {

                // Undo reverse
                k = after - 1 - k;
            }
        }

        return '.';
    }
}

/* TLE: O(n)=2^n

What happens with many #?
Example: s = "a#####"
Lengths become:
1 = a
2 = aa
4 = aaaa
8 = aaaaaaaa
16 = aaaaaaaaaaaaaaaa
32 = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

Work done:              For n hashes:
1 + 2 + 4 + 8 + 16      1 + 2 + 4 + ... + 2^(n-1)
= 31                    = 2^n - 1
≈ 2^5

Therefore: Worst Case
Time  = O(2^n)
Space = O(2^n)

class Solution {
    public char processStr(String s, long k) {

        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                result.append(c);
            }
            else if (c == '*') {
                if (result.length() > 0)
                result.deleteCharAt(result.length()-1);
            }
            else if (c == '#') {
                result.append(result.toString());
            }
            else if (c == '%') {
                result.reverse();
            }
        }
        if(k<result.length())
            return result.charAt((int)k);
        return '.';
    }
}

*/