package com.fly.ftx.swordOffer.questions;


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
        int rowMax = matrix.length -1 , cellMax = matrix[0].length -1;
        if(count < allCount) {
            dg(matrix, result, allCount, count, rowMin, rowMax, cellMin, cellMax);
        }
        return result;
    }

    static void dg(int[][] matrix, int[] result,int allCount, int count, int rowMin, int rowMax, int cellMin, int cellMax){
        // 递归调用
        if(count < allCount) {
            for (int i = cellMin; i <= cellMax && count < allCount; i++) {
                result[count++] = matrix[rowMin][i];
            }
            rowMin ++;
            // 从上到下
            for (int i = rowMin; i <= rowMax && count < allCount; i++) {
                result[count++] = matrix[i][cellMax];
            }   
            cellMax --;
            // 从右到左
            for (int i = cellMax; i >= cellMin && count < allCount; i--) {
                result[count++] = matrix[rowMax][i];
            }
            rowMax --;
            // 从下到上
            for (int i = rowMax; i >=rowMin && count < allCount; i--) {
                result[count++] = matrix[i][cellMin];
            }
            cellMin ++;
        }
        if(count < allCount) {
            dg(matrix, result, allCount, count, rowMin, rowMax, cellMin, cellMax);
        }
    }
    /**
     * 代码改进，更加有效的方法
     * @param matrix
     * @return
     */
    public static int[] enhance(int[][] matrix ) {

        return null;
    }
    public static void main(String[] args) {
        int[][] generateRandom2wInt = Util.generateRandom2wInt(4, 4, 0, 4);
        Util.print2wArray(generateRandom2wInt, "测试数组");
        int[] spiralOrder = spiralOrder(generateRandom2wInt);
        Util.printArray(spiralOrder, "顺时针后的数组");
    }
}
