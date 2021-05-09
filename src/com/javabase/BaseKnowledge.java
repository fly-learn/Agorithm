package com.javabase;

import java.util.Scanner;

/**
 * 华为机试算法题
 */
public class BaseKnowledge {
    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);        
        n = scanner.nextInt();
        System.out.println("数组长度：" + n);
        var strArray = new String[n];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = scanner.next();
        }
        for (String string : strArray) {
            System.out.println("字符信息:" + string);
        }
        if(!lexicographically(strArray, n) && !lengths(strArray, n)) {
            System.err.println("none");
        }
        if(lexicographically(strArray, n) && !lengths(strArray, n)) {
            System.out.println("lexicographically");
        }
         if(lengths(strArray, n) && !lexicographically(strArray, n)) {
            System.out.println("length");
        }else if(lengths(strArray, n) && lexicographically(strArray, n)){
            System.out.println("both");
        }
    

    }
    /**
     * 根据字符排序
     * @param s
     * @param n
     * @return
     */
    static boolean lexicographically(String[] s,int n){
        if(n == 0) return false;
        for (int i = 0; i < s.length -1; i++) {
            char[] charArray = s[i].toCharArray();
            char[] charArray2 = s[i+1].toCharArray();
            if(s[i].length() ==0 && s[i+1].length() ==0) {
                return charArray[0] < charArray2[0];
            }
            int minLength = s[i].length() > s[i+1].length() ? s[i+1].length() : s[i].length();
            for (int j = 0; j < minLength; j++) {
                if(charArray[i] > charArray2[i]) return false;
            }
        }
        return true;
    }
    /**
     * 根据字符长度进行排序
     * @param n
     * @return
     */
    static boolean lengths(String[] str , int n) {
        if(n == 0) return false;
        for (int i = 0; i < str.length-1; i++) {
            if(str[i].length() == str[i] == 1)
            if(str[i].length() > str[i+1].length()) return false;
        }
        return true;
    }
}
    