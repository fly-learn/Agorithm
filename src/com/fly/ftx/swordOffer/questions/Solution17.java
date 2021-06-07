package com.fly.ftx.swordOffer.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 这个题考虑大数情况，我没有理解书上的方法
 */
class Solution17 {
    public static void printNumbers(int n) {
        if (n > 0) {
            char[] number = new char[n +1];
            number[n] = '0';
            for (int i = 0; i < 10; i++) {
                number[0] = Integer.toString(i).charAt(0);
                Print1ToMaxOfNDigitsRecursively(number , n , 0);
            }
        }
    }

    public static void  Print1ToMaxOfNDigitsRecursively(char[] number , int length , int index) {
        if (index ==  length-1) {
            PrintNumber(number);
        }
        for (int i = 0; i < 10; i++) {
            number[index +1] = Integer.toString(i).charAt(0);
            Print1ToMaxOfNDigitsRecursively(number , length , index+1);
        }
    }
    public static void PrintNumber(char[] number) {

    }

    // 测试阶段~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            printNumbers(n);
        }
    }
}

