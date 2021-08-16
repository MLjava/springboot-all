package com.algorithm;

import com.algorithm.repeat.DeleteRepeatElement;
import org.junit.Test;

/**
 * @author malin
 */
public class AlgorithmTest {

    @Test
    public void distinct() {
        DeleteRepeatElement deleteRepeatElement = new DeleteRepeatElement();
        int distinct1 = deleteRepeatElement.distinct(new int[]{1, 2, 4});
        int distinct2 = deleteRepeatElement.distinct(new int[]{1, 4, 3, 4, 3});
        int distinct3 = deleteRepeatElement.distinct(new int[]{1});
        int distinct4 = deleteRepeatElement.distinct(new int[]{});
//        System.out.println(distinct1);
        System.out.println(distinct2);
//        System.out.println(distinct3);
//        System.out.println(distinct4);
    }

}
