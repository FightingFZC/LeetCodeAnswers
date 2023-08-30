/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.46%)
 * Likes:    3360
 * Dislikes: 0
 * Total Accepted:    734.4K
 * Total Submissions: 948.1K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        /*
         * 找规律找出这样的规律
         * 要n对括号的排列组合
         * = "(" + n = p的所有组合 + ")" + n = q的所有组合
         * p + q = n - 1，p从0或者n - 1开始迭代
         */

        // n = 0时为[]，n = 1时为["()"]
        List<List<String>> dp = new ArrayList<>(n + 1);

        // 初始化n=0和n=1的情况
        dp.add(Arrays.asList(""));
        dp.add(Arrays.asList("()"));

        for (int i = 2; i <= n; i++) {
            List<String> now = new ArrayList<>();

            for (int j = i - 1; j >= 0; j--) {

                for (String e1 : dp.get(j)) {
                    for (String e2 : dp.get(i - 1 - j)) {
                        now.add("(" + e1 + ")" + e2);
                    }
                }
            }
            dp.add(now);
        }

        return dp.get(n);
    }
}
// @lc code=end
