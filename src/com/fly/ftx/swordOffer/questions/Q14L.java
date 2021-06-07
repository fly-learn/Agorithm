package com.fly.ftx.swordOffer.questions;

/**
 * 动态规划
 * 从上而下分析问题
 * 从下而上解决问题
 */
public class Q14L {
    public static int cuttingRope(int n) {
        if(n <=3) return n-1;
        int[] points = new int[n + 1];
        // 下满是 n>=4的情况，和n <= 3 不同。不要搞混淆了。
        points[0] = 1;
        points[1] = 1;
        points[2] = 2;
        points[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int point = points[j] * points[i -j];
                if(max < point) max = point;
            }
            points[i] = max;
        }
        max = points[n];
        return max;
    }
    public static void main(String[] args) {
        System.out.println("接到的结果："+ cuttingRope(10));
    }
}
