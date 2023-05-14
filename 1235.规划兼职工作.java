/*
 * @lc app=leetcode.cn id=1235 lang=java
 *
 * [1235] 规划兼职工作
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // sorting based on the end time
        
        int[] dp = new int[n + 1];
        dp[0] = 0; // initialize the first dp
        for (int i = 1; i <= n; i++) {
            int pre = 0;
            for (int j = i - 1; j >= )
        }
    }
}
// @lc code=end

