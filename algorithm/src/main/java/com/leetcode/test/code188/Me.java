package com.leetcode.test.code188;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Me {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        //int[][][] dp01 = new int[prices.length + 1][k + 1][2];
        int[][] dp02 = new int[k + 1][2];
        //return process(prices, 0, k, 0);
        //process01(prices, k, dp01);
        //return dp01[0][k][0];
        process02(prices, k, dp02);
        return dp02[k][0];
    }

    /**
     * 暴力递归
     *
     * @param prices：价格数组
     * @param cur：当前处于哪一天
     * @param k：还剩可以完成的交易数
     * @param status：当前状态，为0则表示之前未买股票，为1则表示之前已买股票
     * @return 在cur天的status下往后最多能完成k笔交易的最大利润
     */
    public int process(int[] prices, int cur, int k, int status) {
        if (cur == prices.length || k == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        if (status == 0) {//如果status为0，则我可以买也可以不买
            p1 = process(prices, cur + 1, k, 1) - prices[cur];//买
            p2 = process(prices, cur + 1, k, 0);//不买
        } else {//如果status为1，则我只能卖，或者不卖
            p1 = process(prices, cur + 1, k - 1, 0) + prices[cur];//卖
            p2 = process(prices, cur + 1, k, 1);//不卖
        }
        return Math.max(p1, p2);
    }

    /**
     * 普通dp
     */
    public void process01(int[] prices, int k, int[][][] dp01) {
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                //dp01[i][j][0]
                dp01[i][j][0] = Math.max(dp01[i + 1][j][1] - prices[i], dp01[i + 1][j][0]);
                dp01[i][j][1] = Math.max(dp01[i + 1][j - 1][0] + prices[i], dp01[i + 1][j][1]);
            }
        }
    }

    /**
     * dp空间压缩，三维变二维
     *
     */
    public void process02(int[] prices, int k, int[][] dp02) {
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                //dp[i][j][0]
                dp02[j][0] = Math.max(dp02[j][1] - prices[i], dp02[j][0]);
                dp02[j][1] = Math.max(dp02[j - 1][0] + prices[i], dp02[j][1]);
            }
        }
    }
}
