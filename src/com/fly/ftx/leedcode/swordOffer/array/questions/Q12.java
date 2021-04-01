package com.fly.ftx.leedcode.swordOffer.array.questions;

import java.util.Stack;

import jdk.nashorn.api.tree.ForInLoopTree;


/**
 * 回溯法
 */
public class Q12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        // 访问数组
        boolean[][] viseted = new  boolean[board.length][board[0].length];
        char[] charArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(charArray[0] == board[i][j]){
                    if(equalStr(i, j, board, charArray, viseted, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean equalStr(int row , int cell ,char[][] board, char[] charArray, boolean[][] visited, int index){
        if(index == charArray.length -1) return true;
        if(row < 0|| cell< 0 || row == board.length || cell==board[0].length || visited[row][cell] || board[row][cell] != charArray[index]) {return false;}
        visited[row][cell] = true;
        boolean res = equalStr(row + 1, cell,board, charArray,visited, index + 1)
                || equalStr(row - 1, cell, board, charArray,visited, index + 1)
                || equalStr(row, cell + 1, board, charArray,visited, index + 1)
                || equalStr(row,cell - 1, board, charArray,visited, index + 1);
        visited[row][cell] = false;
        return res;
    }

}
