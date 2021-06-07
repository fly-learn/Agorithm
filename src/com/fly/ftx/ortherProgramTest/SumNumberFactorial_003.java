package com.fly.ftx.ortherProgramTest;

import java.util.Scanner;

/**
 * 累加 1~n的阶乘： 1! + 2! + ... + n!
 * @author ligelzs
 * @version 1.0
 * @email ligelzs.com
 * @url https://ligelzs.com
 * @date 2021/6/6 20:56
 */
public class SumNumberFactorial_003 {
    /**
     * 加法阶乘
     * @param target 目标值
     * @return int
     */
    public static int addRank(int target) {
        if (target < 0) return -1;
        if (target <= 1) return target;
        int first = 1;
        int sum = 1;
        for (int i =2; i <= target; i++) {
            sum = first + i;
            first = sum;
        }
        return sum;
    }

    /**
     * 乘法阶乘
     * @param target 目标
     * @return int
     */
    public static int multiplyRank(int target) {
        if (target < 0) return -1;
        if (target <= 1) return target;
        int first = 1;
        int sum = 1;
        for (int i =2; i <= target; i++) {
            sum = first * i;
            first = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
//            int add = addRank(n);
//            int multiply = multiplyRank(n);
//            System.out.println("n的加阶乘:" + add);
//            System.out.println("n的乘阶乘:" + multiply);
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum = sum + multiplyRank(i);
            }
            System.out.println("结果：" + sum);
        }
    }
}
