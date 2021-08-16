package com.algorithm.repeat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malin
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 */
public class DeleteRepeatElement {

    /**
     * 空间非O(1)
     * 时间为O(2n)
     * 暴力解法
     *
     * @param nums 数组
     * @return 去重之后的长度
     */
    public int distinct(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return nums.length;
        }

        return 0;
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int distinct2(int[] nums) {
        return 0;
    }

}
