package com.fly.ftx.leedcode.swordOffer.array.bootEntry;
import com.fly.ftx.base.Util;

public class Test {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~执行开始~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int[] generateRandomInt = Util.generateRandomInt(10, 0, 100);
        System.out.println("排序前数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        long currentMilTime = Util.currentMilTime();
        Util.sort(generateRandomInt);
        String bootTimeMs = Util.bootTimeMs(currentMilTime, Util.currentMilTime());
        System.out.println(bootTimeMs);
        System.out.println("排序后数组是否有序：" + Util.checkArrayOrdered(generateRandomInt));
        Util.printArray(generateRandomInt, "排序后的数组");
        int search = (int)Util.OrderSearch(generateRandomInt, 79);
        System.out.println("查询的序列："+ search);

    }
}