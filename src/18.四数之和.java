/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode.cn/problems/4sum/description/
 *
 * algorithms
 * Medium (36.82%)
 * Likes:    1727
 * Dislikes: 0
 * Total Accepted:    499.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
 * nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * 你可以按 任意顺序 返回答案 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // like sum of three nums

        // get one, find three, then get one find two..

        // sort array
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i ++) {

            // equals sum of three nums
            for (int j = i + 1; j < nums.length; j ++) {
                // head index
                int h = j + 1;
                // tail index
                int t = nums.length - 1;

                while (h < t) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[h] + (long)nums[t];
                    if (sum < target) {
                        h ++;
                        
                    } else if (sum > target) {
                        t --;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[h], nums[t]));
                        h ++;
                        t --;
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
// @lc code=end

