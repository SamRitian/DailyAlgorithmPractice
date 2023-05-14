/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = -1;
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (target >= matrix[mid][0]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        if (bottom >= 0 && matrix[bottom][0] <= target) row = bottom;
        if (row == -1) return false;
        
        int left = 0, right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            else if (target > matrix[row][mid]) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
// @lc code=end

// 1, 10, 23, 32  target = 
//         b  t
//            m