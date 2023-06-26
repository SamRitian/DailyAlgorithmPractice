/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) right = mid;
            else left = mid;
        }

        if (target <= nums[left]) return left;
        else if (target <= nums[right]) return right;
        else return right + 1;
    }
}
// @lc code=end