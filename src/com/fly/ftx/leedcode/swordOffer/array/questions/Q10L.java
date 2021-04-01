package com.fly.ftx.leedcode.swordOffer.array.questions;


public class Q10L {
    public static int fib(int n) {
        if(n < 0) return -1;
        if(n == 0 || n==1) return n;
        int first =0, second = 1;
        int result = 0;
        while(--n > 0) {
            result = (first + second) % 1000000007 ;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + fib(12313123));
    }

}
