package com.leetcode.test.code2266;

public class Dalao {

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 开头就是一个')'或者总体个数为奇数,不可能有解
        if (grid[m - 1][n - 1] == '(' || grid[0][0] == ')' || ((m + n + 1) & 1)  == 1) return false;
        return dfs(grid, 0, 0, m - 1, n - 1, 0, 0);
    }

    boolean dfs(char[][] grid, int lx, int ly, int rx, int ry, int left, int right) {
        // 由于题目说了, 只能向右向下走.
        // 所以从左边出发的位置必然是在左上方区域
        // 右边出发的必然在右下方区域
        if (lx > rx || ly > ry) return  false;

        // 左边 左括号剩余
        if (grid[lx][ly] == '(') left++;
        else left--;
        if (left < 0) return false; // 左边出发的路径中 右括号 多于 左括号, 停止

        // 右边 右括号剩余
        if (grid[rx][ry] == ')') right++;
        else right--;
        if (right < 0) return false; // 右边出发的路径中 左括号 多于 右括号, 停止

        // 如果 剩余括号数量 不够 使左右和在一起后成对, 停止
        if (rx - lx + ry - ly - 1 < Math.abs(left - right)) return false; // 情况太极端
        // 如果 剩余括号数量 + 剩余左括号 + 剩余右括号 是奇数, 肯定匹配不了, 停止
        if ((rx - lx + ry - ly - 1 + left + right & 1) == 1) return false;

        // 同行&&左右相邻,  同列&&上下相邻, 则此时相遇
        // 如果相遇 并且 左右括号互补, 则找到解了, 有利用运算符优先级
        if ((lx == rx && ry - ly == 1 || ly == ry && rx - lx == 1) && (left == right)) return true;

        // 双向递归, 思想: 我走的时候你也不能闲着
        // 交叉走是必然的, 不然可能会导致某一边走了很多步后自己崩掉了, 然后下一递归仍然走它
        return dfs(grid, lx, ly + 1, rx, ry - 1, left, right) ||
                dfs(grid, lx + 1, ly, rx - 1, ry, left, right) ||
                dfs(grid, lx, ly + 1, rx - 1, ry, left, right) ||
                dfs(grid, lx + 1, ly, rx, ry - 1, left, right);
    }
}
