package com.fly.ftx.swordOffer.questions;
/**
 * 第十七题
 * 打印从1到最大的n位数
 */

public class Q17 {
    /**
     * 用字符串来代替整数
     * 为的是防止整数类型溢出问题
     * @param n
     * @return
     */
    public static int[] printNumbers(int n) {
       StringBuilder str = new StringBuilder();
       int maxNumber = 9;
       for (int i = 0; i < n; i++) {
           str.append('9');
       }
       maxNumber = Integer.parseInt(str.toString());
       int[] result = new int[maxNumber];
       for (int i = 1; i < maxNumber; i++) {
           result[i -1] = i;
       }
       return result;
    }
    public static void main(String[] args) {
        printNumbers(2);
    }
}
