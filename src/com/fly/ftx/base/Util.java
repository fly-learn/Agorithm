package com.fly.ftx.base;

import com.fly.ftx.base.searchMethod.BinarySearch;
import com.fly.ftx.base.searchMethod.LinearSearch;
import com.fly.ftx.base.sortMethod.QuickSort;

import java.util.Random;


public class Util {
  
    /**
     * 获取当前微妙级别时间
     * @return long
     */
    public static long currentMilTime() {
        return System.currentTimeMillis();
    }
    /**
     * 获取当前纳秒级别时间
     * @return long
     */
    public static long currentNaTime() {
        return System.nanoTime();
    }
    
    /**
     * 计算运行时间,返回字符串
     * 纳秒级别
     * @param startTime
     * @param endTime
     * @param granularity
     * @return String
     */
    public static String bootTimeNs(long startTime , long endTime) {
        long usetime = endTime - startTime;
        if(usetime <= 0) return "运行速度太快，无法测试";
        long useMstime=0l;
        long userWstime=0l;
        long useNstime=0l;
        if(usetime > 999999) {
            useMstime = usetime/1000000;
            userWstime = usetime / 1000 ;
            useNstime = usetime % 1000;
            return "算法运行时间:"+ " "+ useMstime + "ms" +"-"+ userWstime + "ws" +"-"+ useNstime + "ns" ;
        }else if (usetime > 1000) {
            userWstime = usetime / 1000 ;
            useNstime = usetime % 1000;
            return "算法运行时间:"+ " " + userWstime + "ws" + "-" + useNstime + "ns" ;
        }
        return "算法运行时间:"+ " "+ usetime + "ns" ;
    }

    /**
     * 默认单位是毫秒级别的
     * @param startTime
     * @return long
     */
    public static String bootTimeMs(long startTime , long endTime) {
        long useTime = endTime - startTime;
        if(useTime < 0) return "计算错误，结束时间小于开始时间";
        long useMstime = 0l;
        long useStime = 0l;
        if(useTime > 1000) {
            useMstime = useTime % 1000;
            useStime = (useTime / 1000) % 60 ;
            return "算法运行时间:" + " " + useStime + "s" + "-" + useMstime + "ms" ;
        }
        return "算法运行时间:" + " "+ useTime + "ms" ;
    }

    /**
     * 产生指定范围内的int[] 序列
     * @param start
     * @param bound
     * @return int[]
     */
    public static int[] generateRandomInt(int size , int start , int bound) {
        if(size < 0 || start > bound) return null;
        if(start== 0 && bound == 0) return new int[size];
        if(start < -2147483648) start = -2147483648;
        if(start > 2147483647) start = 2147483647;
        if(bound < -2147483648) bound = -2147483648;
        if(bound > 2147483647) bound = 2147483647;

        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            Random random = new Random();
            result[i] = random.nextInt(bound) + start;
        }
       return result;
    }

    /**
     * 生产二维数组
     *  原理是用一维数组来创建的
     * @param start
     * @param bound
     * @param size
     * @return
     */
    public static int[][] generateRandom2wInt(int size ,int length , int start , int bound ) {
        if(size < 0 || start > bound) return null;
        int[][] result = new int [size][];
        for (int i = 0; i < size; i++) {
            int[] generateRandomInt = generateRandomInt(length, start, bound);
            result[i] = generateRandomInt;
        }
        return result;
    }
    /**
     * 打印数组
     * @param source
     */
    public static void printArray (int[] source , String ... message) {
        if(source.length <= 0) return;
        if(message.length != 0) {
            System.out.println("~~~~~~~~~~~~~~~" +message[0]+ "~~~~~~~~~~~~~~~~");
        } 
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
            if(i == source.length -1) System.out.println();
        }
    }
    /**
     * 不带标记的打印单数组
     * @param source
     */
    public static void printArray(int[] source) {
        if(source.length <= 0) return;
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i] + " ");
            if(i == source.length -1) System.out.println();
        }
    }
    /**
     * 答应二维数组ß
     * @param source
     * @param message
     */
    public static void print2wArray(int[][] source , String ... message) {
        if(source.length <= 0) return;
        if(message.length != 0) {
            System.out.println("~~~~~~~~~~~~~~~" +message[0]+ "~~~~~~~~~~~~~~~~");
        } 
        for (int i = 0; i < source.length; i++) {
            printArray(source[i]);
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

    /**
     * 检查数组是否是有序
     * @param source
     * @return
     */
    public static boolean checkArrayOrdered(int[] source) {
        if(source.length == 0) return false;
        boolean flag = true;
        int mid = source.length / 2;
        int j =1;
        if(source[mid] < source[0] || source[mid] > source[source.length -1]) return false;
        while (j < source.length) {
            if(source[j-1] > source[j]) return false;
            j++;
        }
        return flag;
    }

    /**
     * 排序方法，该排序方法默认使用的是快速排序
     * @param source
     */
    public static void sort(int[] source) {
        int left = 0, right = source.length-1;
        QuickSort quickSort = new QuickSort();
        quickSort.LRSort(source, left, right);
    }

    /**
     * 有序数组查询
     * 使用二分法查找方法，查找不到返回数组长度值
     * @param source
     * @param target
     * @return
     */
    public static int OrderSearch (int[] source ,int target) {
        //sort(source);
        BinarySearch binarySearch = new BinarySearch();
        return (int)binarySearch.search(source, target);

    }
    /**
     * 无须数组查找
     * 这里用的是线性查找算法
     * @param source
     * @param target
     * @return
     */
    public static int notOrderSearch(int[] source , int target) {
        LinearSearch linearSearch = new LinearSearch();
        return (int)linearSearch.search(source, target);
    }

}