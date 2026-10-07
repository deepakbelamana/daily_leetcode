class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int suffix = nums[0];
        int suffixProd = 1;
        int[] suffixProduct = new int[nums.length];
        suffixProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            suffixProduct[i] = suffixProd * suffix;
            suffixProd = suffixProduct[i];
            suffix = nums[i];
        }

        int prefix = nums[nums.length - 1];
        int prefixProd = 1;
        int[] prefixProduct = new int[nums.length];
        prefixProduct[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            prefixProduct[j] = prefixProd * prefix;
            prefixProd = prefixProduct[j];
            prefix = nums[j];
        }

        for (int k = 0; k < nums.length; k++) {
            result[k] = suffixProduct[k] * prefixProduct[k];
        }

        return result;
    }
}