/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.30%)
 * Likes:    3256
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 两个链表的节点数目范围是 [0, 50]
 * -100 
 * l1 和 l2 均按 非递减顺序 排列
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
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /* 
         * 1. 设置首节点更小的list为current，另一个list的首节点设置为other，
         * 2. 迭代current（设置pre为current前一个节点），直到碰到current大于other
         * 3. 设置pre的下一个节点为other，设置other为current，重复2
         * 4. 当current迭代到末尾为null时，设置pre.next = other即可
         */

        if (list1 == null) {
            return list2;
        } 
        if (list2 == null) {
            return list1;
        }

        ListNode cur = list1.val <= list2.val ? list1 : list2, ot = list1.val <= list2.val ? list2 : list1, pre = cur, h = cur;
        cur = cur.next;

        while (cur != null) {
            if (cur.val > ot.val) {
                pre.next = ot;
                ot = cur;
                cur = pre.next;
            }

            pre = cur;
            cur = cur.next;
        }

        pre.next = ot;


        return h;
        
    }
}
// @lc code=end
