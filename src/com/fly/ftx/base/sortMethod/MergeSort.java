package com.fly.ftx.base.sortMethod;
import com.fly.ftx.base.Util;
import com.fly.ftx.base.sortMethod.baseSortInterface.LeftRightSortInterface;

/**
 * 合并排序
 */
public class MergeSort implements LeftRightSortInterface {

    @Override
    public void LRSort(int[] source, int left, int right) {
        if(left >= right || right >= source.length) return;
        int mid = left + (right  - left) / 2;
        LRSort(source, left, mid);
        LRSort(source, mid+1, right); 
        merge(source, left, mid, right); 
    }
    
    public static void mergeSort(int[] source  ,int left , int right) {
        if(left >= right || right >= source.length) return;
        int mid = left + (right  - left) / 2;
        mergeSort(source, left, mid);
        mergeSort(source, mid + 1, right);
        merge(source, left, mid, right); 
    }
    /**
     * 合并两个集合
     * @param source
     * @param left
     * @param mid
     * @param right
     */
    static void merge(int[] source , int left , int mid , int right) {
        int n1 = mid -left +1;
        int n2 = right - mid ;
        int[] L = new int[n1] ;
        int[] R = new int[n2] ;
        // 存放在临时数组中
        for (int i = 0; i < n1; i++) {
            L[i] = source[left+ i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = source[mid + 1 +i];
        }
        int i=0, j= 0, k=left;
        while(i < n1 && j< n2) {
            if(L[i] <= R[j]) {
                source[k] = L[i];
                i++;
            }else {
                source[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1) {
            source[k] = L[i];
            k++;
            i++;
        }
        while(j < n2) {
            source[k] = R[j] ;
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~执行开始~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] generateRandomInt = Util.generateRandomInt(100, 0, 100);
        System.out.println("排序前数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        long currentMilTime = Util.currentMilTime();
        mergeSort(generateRandomInt , 0, generateRandomInt.length-1);
        String bootTimeMs = Util.bootTimeMs(currentMilTime, Util.currentMilTime());
        System.out.println(bootTimeMs);
        System.out.println("排序后数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        Util.printArray(generateRandomInt, "排序后的数组");
    }
}
