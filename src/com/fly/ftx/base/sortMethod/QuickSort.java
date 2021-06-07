package com.fly.ftx.base.sortMethod;
import com.fly.ftx.base.Util;
import com.fly.ftx.base.sortMethod.baseSortInterface.LeftRightSortInterface;
import com.fly.ftx.swordOffer.test.BaseTestMode;


/**
 * 快速排序
 */
public class QuickSort extends BaseTestMode implements LeftRightSortInterface{

/**
     * 分片函数
     * @param source
     * @param left
     * @param right
     * @return
     */
    private static int partition (int[] source, int left, int right) {
        int low = left, high = right;
        // 中值点
        int pivot = source[left];
        // 快去排序核心步骤
        while(low < high) {
            while(pivot <= source[high] && low < high) high-- ;
            while(pivot >= source[low] && low < high) low++ ;
            if(low < high) {  
                Util.swap(source, low, high);
            }
        }
        source[left] = source[low];
        source[low] = pivot;
        return high;
    }


    /**
     * 快速排序算法
     */
    @Override
    public void LRSort(int[] source, int left, int right) {
       // 递归出口
       if(left < right) {
        int partion = partition(source, left, right);
        LRSort(source, left, partion);
        LRSort(source, partion+1 , right);
       }
    }

    /**
     * 为了做单元测试用的
     * @param source
     * @param left
     * @param right
     */
    public static void quickSort(int[] source, int left, int right) {
        // 递归出口
       if(left < right) {
        int partion = partition(source, left, right);
        quickSort(source, left, partion);
        quickSort(source, partion+1 , right);
       }
    }
    

    

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] generateRandomInt = Util.generateRandomInt(1000000, 0, 100000);
        System.out.println("排序前数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        long currentMilTime = Util.currentMilTime();
        quickSort(generateRandomInt , 0, generateRandomInt.length-1);
        String bootTimeMs = Util.bootTimeMs(currentMilTime, Util.currentMilTime());
        System.out.println(bootTimeMs);
        System.out.println("排序后数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        //Util.printArray(generateRandomInt, "排序后的驻足");
    }

   
}
