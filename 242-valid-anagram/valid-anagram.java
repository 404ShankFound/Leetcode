class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl!=tl) return false;
        int[] arr = new int[26];
        for(int i=0; i<sl; i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int c : arr){
            if(c!=0)
            return false;
        }
        return true;
    }
}