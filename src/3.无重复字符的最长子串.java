/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.03%)
 * Likes:    8333
 * Dislikes: 0
 * Total Accepted:    2M
 * Total Submissions: 5.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 思路是遍历，定义两个标志位a和b，a不动，b一直往后移动
         * 直到发现一个a-b间已经有了的字母，那么a就跳到这个字母的后面一位，然后b继续
         */
        int head = 0, tail = 1;
        int maxCount = s.length() == 0 ? 0 : 1;
        String subString;
        String currentChar;
        while(tail < s.length()) {
            subString = s.substring(head, tail);
            currentChar = s.charAt(tail) + "";
            int i;
            int count = tail - head;
            if ((i = subString.indexOf(currentChar)) != -1) {
                
                head += i + 1;
            }else {
                count ++;
            }
            if (maxCount < count) {
                maxCount = count;
            }
            tail ++;
        }

        return maxCount;
    }
}
// @lc code=end

