import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] N 字形变换
 *
 * https://leetcode.cn/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (52.07%)
 * Likes:    1988
 * Dislikes: 0
 * Total Accepted:    543.3K
 * Total Submissions: 1M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        /* 
         * 两列含有numRows的字符间，
         * 只有numRows-2列是只有一个字符的
         * 输出的例子中，在n>2时
         * 第一行：分别是s[0]， s[0 + (n + (n - 2)) * 1], s[0 + (n + (n - 2)) * 2]...
         * 第二行：s[1], s[1 + n + (n - 2) - 2 * 1], s[]
         * 
         * 麻了，这种纯找数学规律还是麻烦头大。换种方法得了
         * 直接遍历整个字符串，然后将这个字符加入这个字符对应行的数组得了
         * 
         */
        /*
         * 定性每经过numRows + numRows - 2个字符为一轮循环
         * 
         */
        if (numRows == 1) {
            return s;
        }else if (numRows == 2) {
            char[] cs = new char[s.length()];
            int j = 0;
            for (int i = 0; i < s.length(); i += 2) {
                cs[j ++] = s.charAt(i);
            }
            for (int i = 1; i < s.length(); i += 2) {
                cs[j ++] = s.charAt(i);
            }

            return new String(cs);
        }

        int n1 = numRows, n2 = numRows - 2 > 0 ? numRows - 2 : 0;
        List<List<Character>> all = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            all.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            int flag = i % (n1 + n2);
            Character c = s.charAt(i);
            if (flag < numRows) {
                all.get(flag).add(c);
            }else {
                //numRows - (flag - numRows + 1) - 1
                all.get(numRows * 2 - flag - 2).add(c);
            }
        }
        String ans = "";
        for (List<Character> l : all) {
            char[] temp = new char[l.size()];
            for (int i = 0; i < l.size(); i ++) {
                temp[i] = l.get(i).charValue();
            }
            ans += new String(temp);
        }
        return ans;
    
    }
}
// @lc code=end

