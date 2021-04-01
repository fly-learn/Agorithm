package com.fly.ftx.leedcode.swordOffer.array.questions;

import java.math.BigInteger;
import java.util.Arrays;

public class Q14LL {
    public static int cuttingRope(int n) {
        BigInteger dp[] = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return  dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
    public static void main(String[] args) {
        int cuttingRope = cuttingRope(10);
        System.out.println("结果：" + cuttingRope);
    }
}
