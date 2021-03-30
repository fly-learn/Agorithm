package com.fly.ftx.leedcode.swordOffer.array.questions;


import com.fly.ftx.base.Util;

/**
 * 这一题很难，暂时想不到方法
 */
public class Q29 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        int allCount = matrix.length * matrix[0].length ;
        int[] result = new int[allCount];
        int count = 0;
        int rowMin =0, cellMin = 0;
        int rowMax = matrix.length -1, cellMax = matrix[0].length -1;
        while (count < allCount) {
            // 从左到右
            for (int i = cellMin; i < cellMax && count < allCount; i++) {
                result[count++] = matrix[rowMin][i];

            }
            rowMin ++;
            // 从上到下
            for (int i = rowMin; i < rowMax && count < allCount; i++) {
                result[count++] = matrix[i][cellMax];
            }   
            cellMax --;
            // 从右到左
            for (int i = cellMax; i < cellMin && count < allCount; i--) {
                result[count++] = matrix[rowMax][i];
            }
            rowMax --;
            // 从下到上
            for (int i = rowMax; i < rowMin && count < allCount; i--) {
                result[count++] = matrix[cellMin][i];
            }
            cellMin ++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] generateRandom2wInt = Util.generateRandom2wInt(4, 10, 0, 10);
        Util.print2wArray(generateRandom2wInt, "测试数组");
        int[] spiralOrder = spiralOrder(generateRandom2wInt);
        Util.printArray(spiralOrder, "顺时针后的数组");
    }
}
