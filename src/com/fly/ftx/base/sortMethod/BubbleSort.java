package com.fly.ftx.base.sortMethod;
import com.fly.ftx.base.Util;
import com.fly.ftx.base.sortMethod.baseSortInterface.BaseSort;

/**
 * 冒泡排序
 */
public class BubbleSort implements BaseSort {

    /**
     * 这是经典的冒泡排序
     */
    @Override
    public Object sort(int[] source) {
        var n = source.length;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > 0; j--) {
                if(source[j] < source[j-1]) {
                    Util.swap(source, j, j-1);
                }                
            }
        }
        return source;
    }
    
    /**
     * 双端冒泡，是冒泡排序的升级版
     * @param source
     * @return
     */
    public static Object doubleBulleSort(int[] source) {
        int left= 0, right= source.length-1;
        while (left < right) {
            // 找最小值
            for (int i = left+1; i <= right; i++) {
                if(source[left] > source[i])
                    Util.swap(source, i, left);
            }
            left ++;
            // 找最大值
            for (int i = right-1; i >= left; i--) {
                if(source[right] < source[i])
                Util.swap(source, i, right);
            }
            right --;
        }
        return source;
    }

    public static void main(String[] args) {
        int[] generateRandomInt = Util.generateRandomInt(200000, 0, 1000);
        long currentMilTime = Util.currentMilTime();
        int[] sortEhance = (int[])doubleBulleSort(generateRandomInt);
        String bootTimeMs = Util.bootTimeMs(currentMilTime, Util.currentMilTime());
        //Util.printArray(sortEhance, "排序后的驻足");
        System.out.println(bootTimeMs);
    }
}
