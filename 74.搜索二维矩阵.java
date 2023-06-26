/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;

        // find the row
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == matrix[mid][0]) return true;
            else if (target < matrix[mid][0]) end = mid;
            else start = mid;
        }

        int row = -1;
        if (matrix[end][0] <= target) row = end;
        else if (matrix[start][0] <= target) row = start;
        else return false;

        // find if exists
        int left = 0, right = matrix[row].length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[row][mid]) return true;
            else if (target < matrix[row][mid]) right = mid;
            else left = mid;
        }

        if (matrix[row][left] == target) return true;
        else if (matrix[row][right] == target) return true;

        return false;
    }
}
