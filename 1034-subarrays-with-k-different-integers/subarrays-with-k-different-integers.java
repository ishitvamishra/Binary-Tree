public class Solution {
    // Helper function to count subarrays with at most K distinct integers
    public int atMostK(int[] nums, int K) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        // Traverse the array with right pointer
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) {
                K--;
            }

            // Shrink the window if K becomes negative
            while (K < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    K++;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    // Main function to return number of subarrays with exactly K distinct integers
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
}
