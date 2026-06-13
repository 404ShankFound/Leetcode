class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        // use weight array to calculate sum of characters of individual string
        // as per array sum of chars of each string to be stored in an array result
        // map the element of result modulo 26 to alphabet and store in resultant char array
        // concatenate char array
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int sum = 0;

            for (char ch : words[i].toCharArray()) {
                sum += weights[ch - 'a'];
            }

            int rem = sum % 26;

            ans.append((char) ('z' - rem));
        }

        return ans.toString();
    }
}