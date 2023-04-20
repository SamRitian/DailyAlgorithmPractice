/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int leftBoarder = getLeftBoarder(nums, target);
        int rightBoarder = getRightBoarder(nums, target);

        if (leftBoarder == -2 || rightBoarder == -2) return new int[]{-1, -1};
        if (rightBoarder - leftBoarder > 1) return new int[]{leftBoarder + 1, rightBoarder - 1};
        return new int[]{-1, -1};
    }

    private int getLeftBoarder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBoarder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                leftBoarder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBoarder;
    }

    private int getRightBoarder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBoarder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                rightBoarder = left;
            } else {
                right = mid - 1;
            }
        }
        return rightBoarder;
    }
}
// @lc code=end

// [1, 2, 3, 3, 3, 4, 5, 6] target = 3
