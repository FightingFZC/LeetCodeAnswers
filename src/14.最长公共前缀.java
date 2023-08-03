/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (43.41%)
 * Likes:    2848
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.6M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pub = "";

        int minL = strs[0].length();
        /* 先过一遍，看看有没有长度为0的，顺便找出最小的长度为多少 */
        for (int i = 0; i < strs.length; i++) {
            minL = minL < strs[i].length() ? minL : strs[i].length();
        }
        if (minL != 0) {
            for (int i = 0; i < minL; i++) {
                char temp = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (temp != strs[j].charAt(i)) {
                        return pub;
                    }
                }
                pub += temp;
            }
        }

        return pub;
    }
}
// @lc code=end
