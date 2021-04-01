package com.fly.ftx.leedcode.swordOffer.array.questions;

import com.fly.ftx.base.Util;

/**
 * 第四道题
 */
public class Q04 {
    /**
     * 思路1： 因为每一行和每一列都是有序的，则在每一行和每一类都可以用二分法查询 按照行，将二维数组当成一维数组来处理 思路2：
     * 因为行和和列都是有序的，可以站在二维数组的右上角看事情，如果target比当前值小，则列减一， 如果target比当前值大，则行减一
     * 
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int cell = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && cell >= 0) {
            if (matrix[row][cell] == target)
                return true;
            if (matrix[row][cell] < target)
                row++;
            else
                cell--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] generateRandomInt = Util.generateRandom2wInt(4, 10, 0, 10);
        Util.print2wArray(generateRandomInt, "原始数组");
        long currentNaTime = Util.currentNaTime();
        boolean findNumberIn2DArray = findNumberIn2DArray(generateRandomInt, 2);
        System.out.println("执行结果:" + findNumberIn2DArray);
        String bootTimeMs = Util.bootTimeNs(currentNaTime, Util.currentNaTime());
        System.out.println(bootTimeMs);

    }
}
