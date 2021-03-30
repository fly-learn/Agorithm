package com.fly.ftx.leedcode.swordOffer.array.questions;

/**
 * 第53-ll题
 */
public class Q53ll {

    public static int missingNumber(int[] nums) {
        int low = 0, right = nums.length - 1;
        while (low < right) {
            int mid = low + (right - low) / 2;
            if (nums[mid] != mid) {
                right = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[right] == nums.length - 1 && nums[low] == low ? low + 1 : low;
    }

    public static void main(String[] args) {
        int[] aa = {0,1,2,4};
        int missingNumber = missingNumber(aa);
        System.out.println("缺省的序号:" + missingNumber);

    }
}
