package com.fly.ftx.base.searchMethod;

/**
 * 二分法查询
 */
public class BinarySearch implements SearchBase{
    /**
     * 二分法查询,这里是用死循环来实现的
     * 这里在做题时，检查出很多关于边界的问题。
     * @param source
     * @return
     */
    public Object search(int[] source , int key) {
        int left = 0 , right = source.length-1 , mid;
        // 处理数组只有一个元素情况
        if(source.length ==1 && source[0] == key) {
            return 0;
        }
        if (right >= 1) {
            while(true) {
                mid = left + (right-left)/2 ;
                if(left <= right) {
                    if(key == source[mid]) return mid;
                    if (key < source[mid]) right= mid-1;
                    else left = mid+1;
                } else {
                    // 没有查找到，就返回数组长度,因为长度从1开始计算
                    return source.length;
                }
            }
        }
        return source.length;
    }

    /**
     * 递归实现二分查找
     * @param source
     * @param key
     * @return
     */
    public static Object binarySea(int[] source , int key , int left , int right) {
        if(right >= 1) {
            int mid = left + (right - left)/2;
            if(source[mid] == key) return mid;
            if(source[mid] > key)  return binarySea(source, key, left, mid-1);
            return binarySea(source, key, mid+1, right);
        }
        return source.length;
    }
}