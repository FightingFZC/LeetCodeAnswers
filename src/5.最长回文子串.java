/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (37.44%)
 * Likes:    6279
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.6M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String res = s.charAt(0) + "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 0; r < s.length(); r ++) {
            
            for (int l = 0; l <= r; l ++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 1 || dp[l + 1][r - 1])) {
                    
                    dp[l][r] = true;
                    if (res.length() < r - l + 1) {
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

