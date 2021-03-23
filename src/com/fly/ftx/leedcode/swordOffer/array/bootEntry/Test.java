package com.fly.ftx.leedcode.swordOffer.array.bootEntry;

import com.fly.ftx.base.Util;


public class Test {
    public static void main(String[] args) {
        // 产生指定范围随机数
        System.out.println();
        long startMilTime01 = Util.currentMilTime();
        int[] generateRandomInt = Util.generateRandomInt(20, 10, 30);
        for (int i = 0; i < generateRandomInt.length; i++) {
            System.out.print(generateRandomInt[i] + " ");
            if(i== generateRandomInt.length-1)
                System.out.println();
        }
        System.out.println(Util.bootTime(startMilTime01, Util.currentMilTime(), "微秒"));
        System.out.println();
        
        // 测试算法运行时间
        long startMilTime = Util.currentMilTime();
        long startNaTime = Util.currentNaTime();
        double sum = 0.0;
        for (int i = 0; i < 1000000; i++) {
            var tem = Math.random()*100;
            sum += tem;
        }
        System.out.println("sum的值："+ sum);
        System.out.println(Util.bootTime(startMilTime, Util.currentMilTime(), "微秒"));
        System.out.println(Util.bootTime(startNaTime, Util.currentNaTime(), "纳秒"));

       
    }
    
}