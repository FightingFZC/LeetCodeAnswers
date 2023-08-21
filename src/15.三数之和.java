/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode.cn/problems/3sum/description/
 *
 * algorithms
 * Medium (37.21%)
 * Likes:    6204
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 3.9M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
 * k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 
 * 你返回所有和为 0 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
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
    public List<List<Integer>> threeSum(int[] nums) {
        // /*
        // * key表示两数之和
        // * value为一个数组
        // * 数组内为一个大小为2的数组，表示nums中这两个下标之和为key
        // */
        // Map<Integer, Set<List<Integer>>> map = new HashMap<>();

        // Set<List<Integer>> ans = new HashSet<>();

        // /*
        // * 开始遍历，从第三个数遍历，这个i代表第三个加数
        // * 每次遍历就找nums中i之前的子数组中有没有两数之和为0-i
        // * 遍历的时候把这个子数组的两数之和存在map中，方便下次使用。
        // */
        // Arrays.sort(nums);
        // for (int i = 2; i < nums.length; i++) {
        // int target = 0 - nums[i];
        // int newAdd = nums[i - 1];
        // // 这里更新map，更新完再找。
        // for (int j = 0; j < i - 1; j++) {
        // int key = newAdd + nums[j];
        // Set<List<Integer>> set = map.get(key);
        // if (set == null) {
        // set = new HashSet<>();
        // }
        // set.add(Arrays.asList(nums[j], nums[i - 1]));
        // map.put(key, set);
        // }
        // Set<List<Integer>> set;
        // if ((set = map.get(target)) != null) {
        // Iterator<List<Integer>> iterator = set.iterator();
        // while (iterator.hasNext()) {
        // List<Integer> e = iterator.next();
        // ans.add(Arrays.asList(e.get(0), e.get(1), nums[i]));
        // }
        // }
        // }

        // return new ArrayList<>(ans);

        // 上面的题解超时（个人感觉思路和官方的差不多

        // 首先这是一个不重复容器，方便去重
        Set<List<Integer>> ans = new HashSet<>();

        // 排序
        Arrays.sort(nums);

        /*
         * 排序完就“定一找二”
         * 定一：遍历数组中的每个数，遍历时找二
         * 
         * 找二：定下来一个数后，用双指针（j，k，j < k）遍历这个数后面的子数组
         * 算出两数+定一的数的和，判断与0的关系
         * 1. = 0，加入到集合中
         * 2. < 0，j ++
         * 3. > 0，k --
         * 因为排序过了，所以小了就把可以增大的数增大，大了就把可以减小的数减小
         */

        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j ++;
                    k --;
                } else if (sum < 0) {
                    j ++;
                } else if (sum > 0) {
                    k --;
                }
                
            }

        }

        return new ArrayList<>(ans);
    }

}
// @lc code=end
