package com.yamhto.code;

/**
 * @author yamhto
 * @className: Method1.java
 * @package com.yamhto.code
 * @description:
 * @date 2020/4/29 14:46
 */

import java.util.Arrays;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Method1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 18);

        System.out.println(ints[0] + "----" + ints[1]);
    }


    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (target == sum(nums[i], nums[j])) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}
