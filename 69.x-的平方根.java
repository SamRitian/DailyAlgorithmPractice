/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int left = 0, right = x / 2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            System.out.println("Mid = " + mid);
            if ((long)mid * mid == x) {
                right = mid;
            } else if ((long)mid * mid < x) {
                left = mid;
            } else if ((long)mid* mid > x) {
                right = mid;
            }
        }
        if ((long)right * right <= x) return right;
        if ((long)left * left <= x) return left;
        return -1;
    }
}
// @lc code=end

