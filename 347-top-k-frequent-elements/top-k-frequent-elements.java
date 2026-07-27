import java.util.*;

//Bucket Sort: 
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
        
        // FIX 1: Passing capacity to ArrayList doesn't fill it. We must manually pre-populate with nulls.
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(nums.length + 1); 
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(null);
        }

        // K can range from 0 to n thus K+1 is upper bound 
        for (int num : map.keySet()) { 
            // FIX 2: Replaced bracket syntax [] with .get() and .set()
            int freq = map.get(num);
            if (bucket.get(freq) == null) { 
                bucket.set(freq, new ArrayList<>()); 
            } 
            bucket.get(freq).add(num); 
        } 
        
        List<Integer> list = new ArrayList<>(); 
        //bucket->list->elements count 
        //index from last index to inital indexes untill we encounter k counts excluding null 
        int n = 1; 
        
        // FIX 3: Start from the highest frequency index (nums.length) and decrement downwards
        int i = nums.length; 
        while (n <= k && i >= 0) { 
            if (bucket.get(i) != null) { 
                list.addAll(bucket.get(i)); 
                n += bucket.get(i).size(); 
            } 
            i--; 
        } 
        
        int[] result = new int[list.size()]; 
        for (int j = 0; j < list.size(); j++) { 
            result[j] = list.get(j); // Java automatically converts Integer to int here 
        } 
        return result; 
    } 
}


/*
AlgorithmTime ComplexitySpace ComplexityBest Used WhenMin-Heap\(\mathcal{O}(N \log K)\)\(\mathcal{O}(N + K)\)\(K\) is very small compared to \(N\).

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
*/