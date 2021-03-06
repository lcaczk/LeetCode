package com.wkk.dp;

/**
 * @Time: 2020/6/10上午10:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<=1 || n<=1){
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j != 0){
                    dp[i][j] = dp[i][j-1];
                }
                if(j == 0 && i != 0){
                    dp[i][j] = dp[i-1][j];
                }
                if(i != 0 && j != 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    // 动规优化
    public int uniquePathsI(int m, int n){
        int[] dp = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }
}
