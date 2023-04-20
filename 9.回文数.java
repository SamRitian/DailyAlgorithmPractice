import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    // 普通解法
    // public boolean isPalindrome(int x) {
    //     String numStr = Integer.toString(x);
    //     int left = 0;
    //     int right = numStr.length() - 1;
    //     while (left <= right) {
    //         if (numStr.charAt(left) != numStr.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }

    // 数学解法
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int num = x;
        int inversed = 0;
        while (num != 0) {
            int remainder = num % 10;
            inversed = inversed * 10 + remainder;
            num /= 10;
        }
        System.out.print(inversed);
        return x == inversed;
    }
}
// @lc code=end

