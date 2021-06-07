package com.fly.ftx.swordOffer.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


/**
 * 实现double数的x次方
 */
class Solution16 {

    public double myPow(double x, int n) {
        // 这里关于异常，该怎么返回数据呢？
        if(x ==0.0 && n==0) {
            return -1;
        }else if(x == 0) {
            return 0;
        }else if (n ==0) return 1;
        // 进行乘方处理
        double result = PowerWithUnsignedN(x , n > 0 ? n : -n);
        return n > 0 ? result : 1/result;
    }
    /**
     * @Description TODO:
     * @Problem
     * TODO:
     *   1. 该方法缺点是内存占用太高，这是递归导致的，优化的空间就是改写递归，就是优化递归算法
     *
     * @Author fly-ftx
     * @Date 19:03 2021/5/18
     * @Param [x, n]
     * @return double
     **/
    public double PowerWithUnsignedN(double x , int n) {
        // 递归出口，关于递归出口这里，其实自己是不是很理解的
        if(n==0) return 1;
        double result = PowerWithUnsignedN(x , n >>> 1);
        result = result * result;
        return  (n & 1) == 1 ? result * x : result;
    }
    /**
     * @Description TODO: 用循环来代替递归
     * @Problem
     * TODO:
     *    1. 这个题是失败的，非递归方法没有写出来
     *
     * @Author fly-ftx
     * @Date 19:47 2021/5/18
     * @Param [x, n, a]
     * @return double
     **/
    public double PowerWithUnsignedNotRecursion(double x , int n ) {
        double[] cache = new double[n+1];
        cache[0] = 1.0;
        cache[1] = x;
        cache[2] = x*x;
        double result = 1.0;
        if ((n & 1) == 1) {
            result = x;
            n -=1;
        }
        if (n >= 4) {
            int index = 4;
            while( index < n) {
                cache[index] = cache[index /2] * cache[index /2];
                index = index * 2;
            }
        }
       return cache[n/2] * cache[n/2] * result;
    }
    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            double x = Double.parseDouble(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            double ret = new Solution16().myPow(x, n);
            String out = doubleToString(ret);
            System.out.print(out);
        }
    }
}

