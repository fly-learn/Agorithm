package com.fly.ftx.leedcode.swordOffer.array.questions;



/**
 * 第53题
 */
public class Q53l {
    public static int orderSearch(int[] source , int key) {
        int left = 0 , right = source.length-1 , mid;
        // 处理数组只有一个元素情况
        if(source.length ==1 && source[0] == key) {
            return 0;
        }
        if (right >= 1) {
            while(true) {
                mid = left + (right-left)/2 ;
                if(left <= right) {
                    if(key == source[mid]) return mid;
                    if (key < source[mid]) right= mid-1;
                    else left = mid+1;
                } else {
                    // 没有查找到，就返回数组长度,因为长度从1开始计算
                    return source.length;
                }
            }
        }
        return source.length;
    }

    public static int search(int[] nums, int target) {
        if(nums.length <0) return -1;
        int orderSearch = orderSearch(nums, target);
        if(orderSearch == nums.length) return 0;
        // 用这个来存，不额外开辟空间
        nums[orderSearch] =1;
        int k =1;
        while(orderSearch+k < nums.length)  {
            if(nums[orderSearch+ k] != target) break;
            if(nums[orderSearch+ k] == target) nums[orderSearch] = nums[orderSearch]+1;
            k++;
        }
        k = 1;
        while (orderSearch-k >=0) {
            if(nums[orderSearch - k] != target) break;
            if(nums[orderSearch - k] == target) nums[orderSearch] = nums[orderSearch]+1;
            k++;
        }
        return nums[orderSearch];
    }

    public static void main(String[] args) {
        int[] aa = {1 , 4};
        int search = search(aa, 4);
        System.out.println("获取数量：" + search);
    }
}
