package com.fly.ftx.leedcode.swordOffer.array.questions;

/**
 * 第五题
 */
public class Q05 {

    /**
     * 这算是通过java自带的方法进行操作。
     * 
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();
        if (s == null)
            return null;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == ' ')
                str.append("%20");
            else
                str.append(charAt);
        }
        return str.toString();
    }

    /**
     * 思路： 将字符串转换成字符数组进行操作，因为字符串底层存储数据结构就是字符数组，然后操作字符数组还是很轻松的。 难点：
     * 考虑一下怎么通过不用额外的字符来完成这个工作
     * 
     * @param s
     * @return
     */
    public static String replaceSpace01(String s) {
        if (s == null)
            return null;
        StringBuilder str = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == ' ')
                str.append("%20");
            else
                str.append(charArray[i]);
        }
        return str.toString();
    }

    public static String replaceSpace03(String s) {
        if (s == null)
            return null;
        StringBuilder str = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == ' ')
                str.append("%20");
            else
                str.append(charArray[i]);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        var string = "We are happy.";
        String replaceSpace = replaceSpace01(string);
        System.out.println("替换后的字符串:" + replaceSpace);
    }
}
