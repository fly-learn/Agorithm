package com.fly.ftx.base.searchMethod;

/**
 * 线性搜索
 */
public class LinearSearch implements SearchBase {

    @Override
    public Object search(int[] source, int key) {
        int i=0;
        for (i = 0; i < source.length; i++) {
            if(source[i] == key) return i;
            i++; 
        }
        // 查询不到，返回数组长度
        if(i == source.length) return source.length;
        return null;
    }


    
}