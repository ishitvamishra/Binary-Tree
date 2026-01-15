class Solution {
    public int countAtMost(int[] nums, int k) {
        int left = 0, sum = 0, count = 0;

        for(int right = 0; right < nums.length; right++){
            sum += (nums[right])%2;

            while(sum > k){
                sum -= (nums[left])%2;
                left++;
            }

            count += (right-left+1);
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }
}