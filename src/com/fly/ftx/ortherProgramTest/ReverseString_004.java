package com.fly.ftx.ortherProgramTest;

import java.util.Scanner;

/**
 * 反转字符串
 * @author ligelzs
 * @version 1.0
 * @email ligelzs.com
 * @url https://ligelzs.com
 * @date 2021/6/6 21:38
 */
public class ReverseString_004 {
    public static String reverseString(String str) {
        int length = str.length();
        StringBuilder reverse = new StringBuilder();
        for(int i = length -1; i >= 0 ; i --) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.nextLine();
            if (str == null || str.equals("")) {
                System.out.println("字符串输入为空，请重新输入！");
                continue;
            }
            String reverseStr = new StringBuilder(str).reverse().toString();
            String reverseString = reverseString(str);
            System.out.println("反转后的字符串:" + reverseStr);
            System.out.println("自定义字符方法:" + reverseString);
        }
    }
}
