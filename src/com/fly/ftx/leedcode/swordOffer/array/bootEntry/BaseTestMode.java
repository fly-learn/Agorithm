package com.fly.ftx.leedcode.swordOffer.array.bootEntry;
import com.fly.ftx.base.Util;
import com.fly.ftx.base.sortMethod.baseSortInterface.BaseSort;

/**
 * 测试基类
 */
public class BaseTestMode {
    /**
     * 测试排序算法
     * @param baseSort： 指定排序算法
     * @param args
     * arg[0]: 测试数组大小
     * arg[1]: 大小范围起点
     * arg[2]: 大小范围终点
     * arg[3]: 选择测试时间单位 1=以纳秒为单位， 2=以毫秒为单位
     * @return int[][]
     */
    public static int[][] testSort(BaseSort baseSort , int ... args) {
        var result = new int[2][];
        int[] generateRandomInt = {};
        if (args.length >3 && args[0]!= 0 && args[2] != 0) {
            if(args[1] > 0)
                generateRandomInt = Util.generateRandomInt(args[0], args[1], args[2]);
            else 
                generateRandomInt = Util.generateRandomInt(args[0], 0, args[2]);
        }else {
            generateRandomInt = Util.generateRandomInt(100, 0, 1000);
        }
        // 将排序前数组保存-算是比较耗费时间
        final int  n = generateRandomInt.length;
        int[] preSortArray = new int[n];
        for (int i = 0; i < generateRandomInt.length; i++) {
            preSortArray[i] = generateRandomInt[i];
        }
        String bootTimeMs = null;
        // 判断是否主观设置单位类型
        if(args.length >=4) {
            if(args[3] == 1) {
                bootTimeMs  = performSort(1, baseSort , generateRandomInt);
            }else if(args[3] == 2) {
                bootTimeMs = performSort(2, baseSort, generateRandomInt);
            }
        }else {
            if ( n <=1000 && n >= 0) {
                bootTimeMs = performSort(1, baseSort , generateRandomInt);
            }else {
                bootTimeMs = performSort(2, baseSort, generateRandomInt);
            }
        }
        // 小于50个久直接打印出来
        if(generateRandomInt.length < 100) {
            Util.printArray(preSortArray, "排序前数组");
            Util.printArray(generateRandomInt, "排序后数组");
        }
        System.out.println(bootTimeMs);
        // 将连个数组放在返回数组中
        result[0] = preSortArray;
        result[1] = generateRandomInt;
        return result;
    }

    // 更具不同计量单位执行方法
    private static String performSort (int type, BaseSort baseSort ,int[] source){
        var startTime = 0l;
        String useTime = null;
        if(type == 1){
            // 纳秒
            startTime = Util.currentNaTime();
            baseSort.sort(source);
            useTime = Util.bootTimeNs(startTime, Util.currentNaTime());
        }else if (type == 2) {
            // 毫秒
            startTime = Util.currentMilTime();
            baseSort.sort(source);
            useTime = Util.bootTimeMs(startTime, Util.currentMilTime());
        }
        return useTime;
    }
}
