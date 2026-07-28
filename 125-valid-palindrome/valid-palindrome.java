class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            // Move left pointer forward if it's not alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } 
            // Move right pointer backward if it's not alphanumeric
            else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } 
            // Both pointers are at alphanumeric characters; compare them
            else {
                // Convert both to lowercase to handle case-insensitivity
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
