class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            int[] arr = new int[26];
            Arrays.fill(arr, 0); // NO NEED AS JAVA INITIALISES ALL TO ZERO IN int[]
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            for (int i : arr) {
                sb.append(i).append('#');
            }
            String result = sb.toString();
            if (map.containsKey(result)) {
                map.get(result).add(str);
            } else {
                List<String> st = new ArrayList<String>();
                st.add(str);
                map.put(result, st);
            }
        }
        return new ArrayList<>(map.values());
    }
}