package com.fly.ftx.leedcode.swordOffer.array.bootEntry;

import com.fly.ftx.base.Util;
import com.fly.ftx.base.sortMethod.BaseSort;
import com.fly.ftx.base.sortMethod.SelectionSort;

public class SortTest {
    public static void main(String[] args) {
        BaseSort sortUtil = new SelectionSort();
        int[] generateRandomInt = Util.generateRandomInt(10, 0, 10);
        int[] sort = (int[])sortUtil.sort(generateRandomInt);
        Util.printArray(sort , "排序后的数组");
    }
    
}