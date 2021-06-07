package com.fly.ftx.swordOffer.questions;

import com.fly.ftx.base.Util;

public class Q03 {
    /**
     * 找出数组中任意一个重复的数字
     * 
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > 1)
                return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] generateRandomInt = Util.generateRandomInt(200, 2, 198);
        long currentNaTime = Util.currentNaTime();
        int findRepeatNumber = findRepeatNumber(generateRandomInt);
        String bootTimeMs = Util.bootTimeNs(currentNaTime, Util.currentNaTime());
        System.out.println(bootTimeMs);
        System.out.println("查找到的重复数字：" + findRepeatNumber);
        Util.printArray(generateRandomInt, "原始数组");
    }
}
