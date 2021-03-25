package com.fly.ftx.base;

import java.util.Random;
import java.util.stream.LongStream;

/**
 * 算法工具类
*/
public class Util {
  
    /**
     * 获取当前微妙级别时间
     * @return long
     */
    public static long currentMilTime() {
        return System.currentTimeMillis();
    }
    /**
     * 获取当前纳秒级别时间啊in
     * @return long
     */
    public static long currentNaTime() {
        return System.nanoTime();
    }
    
    /**
     * 计算运行时间,返回字符串
     * @param startTime
     * @param endTime
     * @param granularity
     * @return String
     */
    public static String bootTime(long startTime , long endTime , String granularity ) {
        var usetime = endTime - startTime;
        return "算法运行时间:"+ " "+ usetime + "--"+  granularity ;
    }

    /**
     * 计算运行时间，返回的是数字，可以进行比较
     * 但是要求默认单位相同
     * @param startTime
     * @param endTime
     * @return long
     */
    public static long bootTime(long startTime , long endTime) {
        return endTime - startTime;
    }

    /**
     * 默认单位是毫秒级别的
     * 只传开始时间过来就行
     * @param startTime
     * @return long
     */
    public static long bootTime(long startTime) {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - startTime;
    }

    /**
     * 产生指定范围内的int[] 序列
     * @param start
     * @param bound
     * @return int[]
     */
    public static int[] generateRandomInt(int size , int start , int bound) {
        var result = new int[size];
        for (int i = 0; i < result.length; i++) {
            Random random = new Random();
            result[i] = random.nextInt(bound) + start;
        }
        printArray(result);
       return result;
    }

    /**
     * 打印数组
     * @param source
     */
    public static void printArray (int[] source , String ... message) {
        if(message.length != 0) {
            System.out.println("~~~~~~~~~~~~~~~" +message[0]+ "~~~~~~~~~~~~~~~~");
        } 
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
            if(i == source.length -1) System.out.println();
        }
    }
    /**
     * 交换数据，这里限制为int类型
     * @param source
     * @param x
     * @param y
     */
    public static void swap(int[] source , int x , int y) {
        int tem = source[y];
        source[y] = source[x];
        source[x] = tem;
    }
}