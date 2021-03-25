package com.fly.ftx.base.sortMethod;

import com.fly.ftx.base.Util;

/**
 * 选择排序
 */
public class SelectionSort implements BaseSort{

    @Override
    public Object sort(int[] source) {
            if(source.length == 0) return source;
            int n = source.length;
            for (int i = 0; i < n-1; i++) {
                int min = i;
                for (int j = i+1; j < n; j++) {
                    if(source[min] > source[j])  
                        min = j;
                }
                // 满足条件，交换数据
                /* if(min != i) {
                    int temp = source[min];
                    source[min] = source[i];
                    source[i] = temp;
                } */
              // 这里的交换方法有问题
              if(min != i) {
                   Util.swap(source, i, min);
               }
            }
        return source;
    }

    
}