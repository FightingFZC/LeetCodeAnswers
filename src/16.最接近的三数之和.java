/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode.cn/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.06%)
 * Likes:    1495
 * Dislikes: 0
 * Total Accepted:    506.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 
 * 返回这三个数的和。
 * 
 * 假定每组输入只存在恰好一个解。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /* 
         * 和上道题很像。一样的思路
         */

        // 对数组排序
        Arrays.sort(nums);

        // initial difference
        int diff = Integer.MAX_VALUE;
        // the return value
        int ans = nums[0] + nums[1] + nums[nums.length - 1];

        // get one, find two
        for (int i = 0; i < nums.length; i ++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                int currentDiff = temp - target;
                int abs = Math.abs(currentDiff);
                if (diff > abs) {
                    diff = abs;
                    ans = temp;
                }
                if (currentDiff == 0) {
                    return temp;
                }else if (currentDiff < 0) {
                    j ++;
                }else {
                    k --;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

