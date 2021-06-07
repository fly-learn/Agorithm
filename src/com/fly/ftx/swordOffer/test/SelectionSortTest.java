package com.fly.ftx.swordOffer.test;
import com.fly.ftx.base.sortMethod.SelectionSort;
import com.fly.ftx.swordOffer.test.BaseTestMode;

/**
 * 选择排序测试类
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        int[][] testSort = BaseTestMode.testSort(new SelectionSort(), 100400, 0, 131313);
        // Util.printArray(testSort[0], "排序前数组");
        // Util.printArray(testSort[1], "排序后数组");
        
    }
    
}