package com.fly.ftx.leedcode.swordOffer.array.questions;

/**
 * 第二10道题
 */
public class Q10LL {
    /**
     * 这个题就是分治问题
     * 问题：
     *  这一题的有个点没有理解，我一开始找的基础点事 1 和 2 然后争取的点是 0 和
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if(n == 0)return -1;
        if(n ==1 || n==2) return n;
        return numWays( n-1) +numWays(n-2);
    }

    public static int other01 (int n) {
        if(n == 0)return 1;
        if(n ==1 || n==2) return n;
        int first = 1, second = 1;
        int result = 0;
        while(--n > 0) {
            result = (first + second ) % 1000000007;
            first = second;
            second = result;
        }
        return result;
    }
    public static void main(String[] args) {
        int n =10;
        int numWays = numWays(n);
        System.out.println("方案总数："+ numWays);
        int other01 = other01(n);
        System.out.println("方案总数：" + other01);
    }
}