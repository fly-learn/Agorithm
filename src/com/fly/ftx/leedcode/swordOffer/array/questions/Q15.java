package com.fly.ftx.leedcode.swordOffer.array.questions;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/**
 * 第15道题
 */
public class Q15 {
    public static int hammingWeight(int n) {
        int count = 0;
        int sum =0;
        while(count < 32) {
            if((n & 1) == 1) {
                sum ++ ;
            }
            n = n >> 1;
            count ++;
        }   
        return sum;
    }
    
    /**
     * 把一个整数减去1之后再与原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的1变成0
     * 很多位运算问题都可以用这个方法来解决。
     * @param n
     * @return
     */
    public static int enhance(int n) {
        int count =0;
        while (n != 0) {
            count ++;
            n = n&(n-1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(5 & 3);
        System.out.println("位数:" + hammingWeight(00000000000000000000000000001011));
    }
}
    