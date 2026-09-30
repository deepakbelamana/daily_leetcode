class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> hashMap = new HashMap<>();
        List<List<String>> result = new LinkedList<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (hashMap.containsKey(sorted)) {
                LinkedList<String> newList = hashMap.get(sorted);
                newList.add(s);
                hashMap.put(sorted, newList);
            } else {
                hashMap.put(sorted, new LinkedList<String>(List.of(s)));
            }
        }

        for (Map.Entry<String, LinkedList<String>> entry : hashMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}