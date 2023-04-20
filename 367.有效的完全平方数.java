/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;

        int left = 2, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid > num) {
                right = mid - 1;
            } else if ((long)mid* mid < num) {
                left = mid + 1;   
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

