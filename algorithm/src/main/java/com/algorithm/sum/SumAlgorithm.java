package com.algorithm.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author malin
 * 给定一个整数数组 nums 和一个整数目标值target，请你在该数组中找出 和为目标值target的那两个整数，并返回它们的数组下标。
 */
public class SumAlgorithm {

    private final int[] nums;

    public SumAlgorithm(int[] nums) {
        this.nums = nums;
    }

    /**
     * O(n2)
     *
     * @param target 目标参数
     * @return 两参数之和的数组索引
     */
    public int[] getArrayIndex(int target) {
        int[] result = new int[2];
        outer:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break outer;
                }
            }
        }
        return result;
    }

    /**
     * O2(n)
     *
     * @param target 目标参数
     * @return 两参数之和的数组索引
     */
    public int[] getArrayIndex2(int target) {
        int[] result = new int[2];
        // key为数组的数值，value为数组的索引
        Map<Integer, Integer> container = new HashMap<>(nums.length + 2);
        for (int i = 0; i < nums.length; i++) {
            container.put(nums[i], i);
        }
        // 循环一遍数组，目标数字减去数组索引得到map的key，通过map的key获取索引
        for (int i = 0; i < nums.length; i++) {
            int mapKey = target - nums[i];
            if (container.containsKey(mapKey)) {
                result[1] = container.get(mapKey);
                result[1] = i;
            }
        }
        return result;
    }

}
