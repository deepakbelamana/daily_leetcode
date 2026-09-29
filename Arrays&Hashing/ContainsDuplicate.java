class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums) {
            hashSet.add(i);
        }

        return nums.length != hashSet.size();
    }
}