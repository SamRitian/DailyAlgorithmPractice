import java.util.Arrays;

public class PalindromicSequence {
  public static int maxScore(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    int[] left = new int[26];
    int[] right = new int[26];

    // initialize left and right arrays
    Arrays.fill(left, -1);
    Arrays.fill(right, -1);
    for (int i = 0; i < n; i++) {
        int c = s.charAt(i) - 'a';
        if (left[c] == -1) {
            left[c] = i;
        }
        right[c] = i;
    }

    // dynamic programming to fill dp table
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i + 1; j < n; j++) {
            dp[i][j] = dp[i + 1][j];
            for (int k = i + 1; k <= j; k++) {
                if (left[s.charAt(i) - 'a'] < left[s.charAt(k) - 'a'] && right[s.charAt(i) - 'a'] > right[s.charAt(k) - 'a']) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][k - 1] + dp[k][j] + 2);
                }
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int len1 = dp[0][i];
            int len2 = dp[i + 1][j - 1];
            int len3 = dp[j][n - 1];
            if (len1 > 0 && len2 > 0 && len3 > 0) {
                ans = Math.max(ans, len1 * len2 * len3);
            }
        }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println("The max score is: " + maxScore("attract"));
  }
}
