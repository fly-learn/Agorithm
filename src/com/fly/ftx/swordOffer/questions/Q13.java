package com.fly.ftx.swordOffer.questions;

public class Q13 {
    public static int movingCount(int m, int n, int k) {
        if(m < 0 || n < 0 || k <0) return 0;
        boolean[][] viseted = new boolean[m][n];
        int count = novingCountCenter(0, 0, m, n, k, viseted);
        return count;
     }
 
     public static int novingCountCenter(int m, int n, int rows, int cells, int k, boolean[][] viseted) {
         if (m < 0 || m >= rows || n < 0 || n >= cells || (m/10 + m%10 + n/10 + n%10) > k || viseted[m][n]){
             return 0;  
         }       
         viseted[m][n] = true;
         int count = 1
         +novingCountCenter(m-1, n, rows, cells, k ,viseted) 
         + novingCountCenter(m+1, n, rows, cells , k, viseted)
         + novingCountCenter(m, n-1,rows, cells, k, viseted) 
         + novingCountCenter(m, n+1, rows, cells, k, viseted);
         return count;
     }


    public static int moving(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private static int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) + 
               dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
    }
    public static void main(String[] args) {
        int movingCount = movingCount(1, 2, 1);
        System.out.println("得到结果：" + movingCount);
        int moving = moving(1, 2, 1);
        System.out.println("得到结果：" + moving);
    }
}
