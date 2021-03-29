package com.fly.ftx.base.sortMethod;

import com.fly.ftx.base.Util;
import com.fly.ftx.base.sortMethod.baseSortInterface.BaseSort;

/**
 * 堆排序
 */
public class HeapSort implements BaseSort {
    
    @Override
    public Object sort(int[] source) {
        int n = source.length;
 
        // 创建堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(source, n, i);
 
        // 一个一个删除头结点
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = source[0];
            source[0] = source[i];
            source[i] = temp;
            // 调整大顶堆
            heapify(source, i, 0);
        }
        return null;
    }

    /**
     * 堆排序
     * @param source
     */
    static void heapSort(int[] source) {
        int n = source.length;
 
        // 创建堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(source, n, i);
 
        // 一个一个删除头结点
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = source[0];
            source[0] = source[i];
            source[i] = temp;
            // 调整大顶堆
            heapify(source, i, 0);
        }
    }
    /**
     * 调大顶堆
     * @param source
     * @param n：数组总数
     * @param i：要调整的节点
     */
    static void heapify(int[] source, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && source[l] > source[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && source[r] > source[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            Util.swap(source, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(source, n, largest);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~执行开始~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] generateRandomInt = Util.generateRandomInt(100, 0, 100);
        System.out.println("排序前数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        long currentMilTime = Util.currentMilTime();
        heapSort(generateRandomInt);
        String bootTimeMs = Util.bootTimeMs(currentMilTime, Util.currentMilTime());
        System.out.println(bootTimeMs);
        System.out.println("排序后数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        Util.printArray(generateRandomInt, "排序后的数组");
    }
}
