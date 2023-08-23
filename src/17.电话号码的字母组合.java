/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (58.10%)
 * Likes:    2591
 * Dislikes: 0
 * Total Accepted:    736.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        // list nums to chars
        String[][] map = { {}, {}, { "a", "b", "c" },
                { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
                { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" },
                { "w", "x", "y", "z" } };

        // index of each num of digits in map

        int[] indexs = new int[digits.length()];
        int len = indexs.length;
        if (len == 0) {
            return ans;
            
        }

        /*
         * 思路就是按时针那样搞。
         * 一次次递进
         */
        a: while (true) {
            // 进循环后就将对应的值加进去
            StringBuilder one = new StringBuilder();
            for (int i = 0; i < len; i++) {
                one.append(map[digits.charAt(i) - '0'][indexs[i]]);
            }
            ans.add(one.toString());

            indexs[len - 1]++;

            /*
             * if indexs[len - 1] great than or equal
             * len of index matched num of digits in map,
             * then set indexs[len - 1] to 0 and set index[len - 2] to ++,
             * if indexs[len - 2] great .....
             */

            for (int i = len - 1; i >= 0 && indexs[i] >= map[digits.charAt(i) - '0'].length; i--) {
                
                if (i == 0) {
                    break a;
                }
                
                indexs[i] = 0;
                indexs[i - 1] ++;
            }
            
        }

        return ans;
    }

}
// @lc code=end
