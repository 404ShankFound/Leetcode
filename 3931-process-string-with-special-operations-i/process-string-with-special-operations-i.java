class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();

        int n = s.length(); // Here we take length of original string not intermediate
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if ('a' <= c && c <= 'z') {
                str.append(c);
            }
            else if (c == '*') {
                if (str.length() > 0) {
                    // otherwise length = 0 so 0-1=-1 StringIndexOutOfBoundsException
                    str.deleteCharAt(str.length() - 1);
                }
            }
            else if (c == '#') {
                str.append(str.toString());
            }
            else if (c == '%') {
                str.reverse();
            }
        }

    return str.toString();
    }
}