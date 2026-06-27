class Solution {
    public int maximumLength(int[] nums) {

        int ans = 1;

        HashMap<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            long x = num;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (long x : map.keySet()) {

            if (x == 1) {
                int cnt = map.get(1L);
                ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
                continue;
            }

            long cur = x;
            int len = 0;

            while (map.getOrDefault(cur, 0) >= 2) {
                len += 2;
                cur = cur * cur;
            }

            if (map.getOrDefault(cur, 0) >= 1)
                len += 1;
            else
                len -= 1;

            ans = Math.max(ans, len);
        }
        return ans;
    }
}