import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    Map<Character, Integer> symbolValues = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int n = s.length();
        int ans = symbolValues.get(s.charAt(n - 1));
        for (int i = n - 1; i > 0; i--) {
            int val = symbolValues.get(s.charAt(i));
            int preVal = symbolValues.get(s.charAt(i - 1));
            if (val <= preVal) {
                ans += preVal;
            } else {
                ans -= preVal;
            }
        }
        return ans;
    }
}
// @lc code=end

