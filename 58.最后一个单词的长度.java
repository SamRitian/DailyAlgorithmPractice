/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int end = s.length() - 1; end >= 0; end--) {
            if (s.charAt(end) != ' ') {
                count++;
            }

            if (count != 0 && s.charAt(end) == ' ') break;
        }
        return count;
    }
}
// @lc code=end

