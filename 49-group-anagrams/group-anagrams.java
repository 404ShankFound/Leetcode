class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            StringBuilder sb = new StringBuilder("");
            int[] arr = new int[26];
            Arrays.fill(arr, 0);
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            for (int i : arr) {
                sb.append(i).append('#');
            }
            String result = sb.toString();
            if (map.containsKey(result)) {
                List<String> st = map.get(result);
                st.add(str);
                map.put(result, st);
            } else {
                List<String> st = new ArrayList<String>();
                st.add(str);
                map.put(result, st);
            }
        }
        for (List<String> value : map.values()) {
            l.add(value);
        }
        return l;
    }
}