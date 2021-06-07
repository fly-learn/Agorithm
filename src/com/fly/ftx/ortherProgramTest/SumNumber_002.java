package com.fly.ftx.ortherProgramTest;

import java.util.Scanner;

/**
 * 累加 1 ~n的结果
 * @author ligelzs
 * @version 1.0
 * @email ligelzs.com
 * @url https://ligelzs.com
 * @date 2021/6/6 20:28
 */
public class SumNumber_002 {
    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 0; i <= 10/2 ; i++) {
//            sum += 11;
//        }
//        System.out.println("1~10累加：" + sum);
        Scanner in = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int n = in.nextInt();
            if (n <= 1) {
                System.out.println("累加结果：" + n);
                continue;
            }
            for (int i = 0; i <= n/2; i++) {
                if (n % 2 == 0 && i == n/2) {
                    sum = sum + i;
                    continue;
                }
                sum = sum + i + n-i;
            }
            System.out.println("累加结果：" + sum);
            sum = 0;
        }

    }
}
