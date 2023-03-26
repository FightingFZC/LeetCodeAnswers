/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 *
 * https://leetcode.cn/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (30.86%)
 * Likes:    3511
 * Dislikes: 0
 * Total Accepted:    356.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * 
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 
 * 
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        /* 双指针，分别指向s和p */
        int i1 = 0, i2 = 0;
        char c1 = 0, c2 = 0;
        while (i1 < s.length() && i2 < p.length()) {
            System.out.println(i1 + " " + i2);
            c1 = s.charAt(i1);
            c2 = p.charAt(i2);
            if (isSame(c1, c2)) {
                i1 ++;
                i2 ++;
            } else {
                if (i2 + 1 < p.length() && p.charAt(i2 + 1) == '*') {
                    i2 += 2;
                }else if (c2 == '*') {
                    char r;
                    if (i2 - 1 >= 0 && i2 + 1 < p.length() && p.charAt(i2 - 1) == (r = p.charAt(i2 + 1))) {
                        /* 如果碰到a*a这样的情况，等效于aa* */
                        p = p.substring(0, i2) + r + c2 + p.substring(i2 + 2, p.length());
                    } else if (i2 - 1 >= 0 && isSame(p.charAt(i2 - 1), c1)){
                        i1 ++;
                    } else {
                        i2 ++;
                    }
                } else {
                    return false;
                }
            }
        }
        System.out.println(i1);
        System.out.println(i2);
        return i1 == s.length() && (i2 == p.length() || (i2 == p.length() - 1 && c2 == '*')) ? true : false;
    }

    public boolean isSame(char a, char b) {
        return a == '.' || b == '.' ? true : a == b;
    }
}
// @lc code=end

