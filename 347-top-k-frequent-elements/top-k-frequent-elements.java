class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k > nums.length) {
            return new int[]{};
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.putIfAbsent(nums[i], 1);
            }
        }
        Queue<Integer> minHeap = new PriorityQueue<Integer>(k, (a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Removes the least frequent element currently in the heap
            }
        }

        // 3. Convert the heap into the final result array: O(K log K) time
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}