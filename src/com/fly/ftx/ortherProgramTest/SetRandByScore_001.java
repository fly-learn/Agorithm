package com.fly.ftx.ortherProgramTest;

import java.util.Scanner;

/**
 * >=90 用A表示
 * 60 =< score <=89 用B表示
 * score < 60 用B表示
 * @author ligelzs
 * @version 1.0
 * @email ligelzs.com
 * @url https://ligelzs.com
 * @date 2021/6/6 20:15
 */
public class SetRandByScore_001 {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            float score = in.nextFloat();
            if (score < 0f || score > 100f) {
                System.out.println("分数不符合大于等于0 小于等于100的范围");
                continue;
            }
            if (score < 60f) System.out.println("C");
            else if (score >= 90f) System.out.println("A");
            else System.out.println("B");
        }
    }
}
