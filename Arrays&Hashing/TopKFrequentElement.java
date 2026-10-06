class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, LinkedList<Integer>> treeMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int value = entry.getValue();
            if (treeMap.containsKey(value)) {
                LinkedList<Integer> existing = treeMap.get(value);
                existing.add(entry.getKey());
                treeMap.put(value, existing);
            } else {
                treeMap.put(value, new LinkedList<Integer>(List.of(entry.getKey())));
            }
        }

        int[] result = new int[k];
        int tr = 0;

        for (Map.Entry<Integer, LinkedList<Integer>> entry : treeMap.descendingMap().entrySet()) {
            for (int value : entry.getValue()) {
                result[tr++] = value;
                if (tr == k) {
                    return result;
                }
            }
        }

        return result;
    }
}

//o(n)

/**
 *class Solution {
 *     public int[] topKFrequent(int[] nums, int k) {
 *         Map<Integer, Integer> freq = new HashMap<>();
 *         for (int n : nums) {
 *             freq.merge(n, 1, Integer::sum);
 *         }
 *
 *         // buckets[i] = numbers that appear exactly i times
 *         List<Integer>[] buckets = new List[nums.length + 1];
 *         for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
 *             int count = entry.getValue();
 *             if (buckets[count] == null) {
 *                 buckets[count] = new ArrayList<>();
 *             }
 *             buckets[count].add(entry.getKey());
 *         }
 *
 *         int[] result = new int[k];
 *         int idx = 0;
 *
 *         for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
 *             if (buckets[i] == null) continue;
 *             for (int num : buckets[i]) {
 *                 result[idx++] = num;
 *                 if (idx == k) {
 *                     return result;
 *                 }
 *             }
 *         }
 *
 *         return result;
 *     }
 * }
 */