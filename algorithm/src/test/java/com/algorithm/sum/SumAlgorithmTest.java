package com.algorithm.sum;

import org.junit.Test;

import java.util.Arrays;

public class SumAlgorithmTest {

    @Test
    public void getArrayIndex() {
        int[] nums = new int[]{1, 3, 6, 8, 7};
        SumAlgorithm sumAlgorithm = new SumAlgorithm(nums);
        int[] arrayIndex = sumAlgorithm.getArrayIndex(7);
        System.out.println(Arrays.toString(arrayIndex));
    }


    @Test
    public void getArrayIndex2() {
        int[] nums = new int[]{1, 3, 6, 8, 7};
        SumAlgorithm sumAlgorithm = new SumAlgorithm(nums);
        int[] arrayIndex = sumAlgorithm.getArrayIndex2(7);
        System.out.println(Arrays.toString(arrayIndex));
    }

}
