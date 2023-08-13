package Question2;
// a
public class LongestSubsequence {
    
        public static int longestSubsequence(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
    
            for (int i = 0; i < n; i++) {
                dp[i] = 1; // Initialize each element as a subsequence of length 1
    
                // Find the maximum length subsequence ending at index i
                for (int j = 0; j < i; j++) {
                    if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
    
            // Find the maximum value in the dp array
            int maxLength = 0;
            for (int len : dp) {
                maxLength = Math.max(maxLength, len);
            }
    
            return maxLength;
        }
    
        public static void main(String[] args) {
            int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
            int k = 3;
            System.out.println(longestSubsequence(nums, k)); // Output: 5
        }
}
    

