/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        // int firstIndex = getFirstIndex(nums, target);
        // int lastIndex = getLastIndex(nums, target);

        int firstIndex = getIndex(nums, target, true);
        int lastIndex = getIndex(nums, target, false);

        if (firstIndex == -1 || lastIndex == -1) {
            return new int[]{-1, -1};
        } else if (nums[firstIndex] == target && nums[lastIndex] == target) {
            return new int[]{firstIndex, lastIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int getIndex(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isFirst) {
                if (target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        if (isFirst) {
            if (left < nums.length && target == nums[left]) return left;
            else return -1;
        } else {
            if (right >= 0 && target == nums[right]) return right;
            else return -1;
        }
    }
}
// @lc code=end

// [1, 2, 3, 3, 3, 4, 5, 6] target = 3
