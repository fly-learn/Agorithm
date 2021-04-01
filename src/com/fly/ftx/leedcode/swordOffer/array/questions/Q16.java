package com.fly.ftx.leedcode.swordOffer.array.questions;

public class Q16 {
    public static double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (x != 0.0 && n == -1)
            return 1.0 / x;
        double result = 0.0;
        if(n < 0) result= powWithUnsign(x, -n);
        else result = powWithUnsign(x, n);
        if (n > 0) {
            return result;
        } else if (n < 0) {
            return 1.0 / result;
        }
        return result;
    }

    public static double powWithUnsign(double x, int n) {
        if( n == 1) return x;
        if(n == 0) return 1;
        if ((n & 1) == 1) {
            return powWithUnsign(x * x, n >>> 1) * x;
        } else {
            return powWithUnsign(x * x, n >>> 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("结果：" + myPow(2.0000, 10));
    }
}
