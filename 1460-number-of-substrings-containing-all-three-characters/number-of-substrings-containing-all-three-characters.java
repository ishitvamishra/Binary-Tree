class Solution {
    // Function to count substrings containing at least one 'a', 'b', and 'c' using sliding window
    public int numberOfSubstrings(String s) {
        // Frequency array for 'a', 'b', 'c'
        int[] freq = new int[3];

        // Left pointer for the sliding window
        int left = 0;

        // Result variable to store count of valid substrings
        int res = 0;

        // Traverse the string with right pointer
        for (int right = 0; right < s.length(); right++) {
            // Increment frequency of current character
            freq[s.charAt(right) - 'a']++;

            // Shrink the window from the left while all characters are present
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // Count substrings from current right to end
                res += (s.length() - right);

                // Move left pointer and update frequency
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;
    }
}