import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode.cn/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (42.15%)
 * Likes:    8805
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 3.7M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 
 * 题目数据保证列表表示的数字不含前导零
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化两个变量等于参数
        ListNode v1 = l1;
        ListNode v2 = l2;
        // 返回的结果
        ListNode retHead = new ListNode();
        ListNode retCurrent = retHead;
        ListNode last = new ListNode();
        // 两位相加得到的和的十位数值
        int tenBit = 0;
        while (v1 != null && v2 != null) {
            // 1. 先算出当前位相加得到的和
            int sum = v1.val + v2.val + tenBit;
            // 2. 算出个位的结果是什么，要加上上一位相加得到的多余的数
            int onebit = sum % 10;
            // 3. 算多出的十位数
            tenBit = sum / 10;

            // 4. 将结果存入
            retCurrent.val = onebit;
            retCurrent.next = new ListNode();
            last = retCurrent;
            retCurrent = retCurrent.next;

            // 5. 将当前加数的节点转到下一个
            v1 = v1.next;
            v2 = v2.next;
        }

        // 到这表示有个加数加完了，要是另外一个数没加完就下面
        ListNode finalAddNum = v1 == null ? v2 : v1;

        while (finalAddNum != null) {
            retCurrent.val = (tenBit + finalAddNum.val) % 10;
            tenBit = (tenBit + finalAddNum.val) / 10;
            retCurrent.next = new ListNode();
            last = retCurrent;
            retCurrent = retCurrent.next;

            finalAddNum = finalAddNum.next;
        }

        if (tenBit != 0) {
            retCurrent.val = tenBit;
        } else {
            last.next = null;
        }

        return retHead;
    }
}
// @lc code=end
