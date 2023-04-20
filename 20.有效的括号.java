import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Map<Character, Character> map = new TreeMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

