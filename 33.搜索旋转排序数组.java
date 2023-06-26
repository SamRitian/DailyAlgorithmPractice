/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) right = mid;
                else left = mid;
            } else {
                if (nums[mid] <= target && target <= nums[right]) left = mid;
                else right = mid;
            }
        }

        if (target == nums[left]) return left;
        if (target == nums[right]) return right;

        return -1;
    }
}
// @lc code=end


              