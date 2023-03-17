import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.64%)
 * Likes:    6353
 * Dislikes: 0
 * Total Accepted:    906.9K
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //1. convert int[] to List<Integer>

        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        for (int i = 0; i < nums1.length; i ++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i ++) {
            list.add(nums2[i]);
        }
        //2. sort list，then get the mid num
        list.sort(null);
        int mid = list.size() / 2;
        double result = list.size() % 2 == 0 ? ((double)list.get(mid) + (double)list.get(mid - 1)) / 2 : list.get(mid);
        // Arrays.stream(list.toArray(new Integer[]{})).forEach(System.out::println);
        return result;
    }
}
// @lc code=end
