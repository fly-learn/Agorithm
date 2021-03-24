package com.fly.ftx.base.searchMethod;

/**
 * 线性搜索
 */
public class LinearSearch implements SearchBase {

    @Override
    public Object search(int[] source, int key) {
        for (int i = 0; i < source.length; i++) {
            if(source[i] == key) return i;
            i++; 
        }
        return null;
    }


    
}