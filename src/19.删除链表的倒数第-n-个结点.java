/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 *
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (45.98%)
 * Likes:    2645
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1], n = 1
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * 
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 */

// @lc code=start
/* *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /* 
         * if you want to scan once, you should set a cache array,
         * the steps ars as follows:
         * 1. scan listnode and add each node to chche array
         * 2. then set array[array.length - n - 1].next to array[array.length - n + 1]
         * 2.1. if array.length - n - 1 out of bound, set array[0] to head
         * 2.2. if array.length - n + 1 out of bound, step 2 shoud set it to null
         * 
         */

        ListNode h = head, current = head;
        List<ListNode> list = new ArrayList<>();

        while (current != null) {
            list.add(current);
            current = current.next;
        }
        
        int len = list.size();

        if (len == 1) {
            return null;
        }
        if (len - n == 0) {
            h = list.get(1);
        }else if (len - n == len - 1) {
            list.get(len - 2).next = null;
        }else {
            list.get(len - n - 1).next = list.get(len - n + 1);
        }

        return h;
    }
}
// @lc code=end

