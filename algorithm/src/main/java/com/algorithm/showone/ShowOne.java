package com.algorithm.showone;

import java.util.HashMap;
import java.util.Map;

/**
 * @author malin
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class ShowOne {

    private final int[] array;

    public ShowOne(int[] array) {
        this.array = array;
    }

    /**
     * 暴力破解
     *
     * @return 使用额外的空间
     */
    public int onlyShowOne() {
        int only = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : array) {
            int sum = 0;
            for (int j : array) {
                if (k == j) {
                    sum++;
                }
            }
            if (sum == 1) {
                map.put(k, sum);
            }
        }
        for (Integer value : map.keySet()) {
            only = value;
            break;
        }
        return only;
    }
}
