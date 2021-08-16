package com.algorithm.showone;

import org.junit.Test;

public class ShowOneTest {

    @Test
    public void testOnlyShowOne() {
        int[] array = new int[]{4, 4, 2, 2, 2, 1};
        ShowOne showOne = new ShowOne(array);
        int i = showOne.onlyShowOne();
        System.out.println(i);
    }


}
