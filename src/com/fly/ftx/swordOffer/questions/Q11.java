package com.fly.ftx.swordOffer.questions;


/**
 * 第11道题
 */
public class Q11 {
    public static int minArray(int[] numbers) {
        int low =0, high = numbers.length-1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if (numbers[mid] < numbers[high]) {
                high = mid ;
            }else if (numbers[mid] > numbers[high]) {
                low = mid +1;
            }else {
                // 这里考虑到相等的情况
                high --;
            }
        }
        return numbers[low];
    }
    public static void main(String[] args) {
        int[] numbers = {2,2,2,0,1};
        int minArray = minArray(numbers);
        System.out.println("要搜索的信息：" + minArray);
    }
}
