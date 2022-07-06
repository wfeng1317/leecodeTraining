package com.leetcode.test.code1754;

public class Dalao01 {
    public String largestMerge(String word1, String word2) {
        char[] charArr = new char[word1.length() + word2.length()];
        //i1，j1记录word1的非递减序列（不包含j1）；i2，j2记录word2的非递减序列（不包含j2）
        //i记录返回字符串charArr的写入位置
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0, i = 0;
        boolean w1 = true;//记录写入word1的非递减序列，还是写入word2的非递减序列
        while (i1 < word1.length() || i2 < word2.length()) {
            //找出word1开头的递增序列
            if (i1 == j1) {
                while (true) {
                    if (j1 == word1.length()) {
                        break;
                    }
                    j1 ++;
                    if (j1 == word1.length() || word1.charAt(j1) < word1.charAt(j1-1)) {
                        break;
                    }
                }
            }
            //找出word2开头的非递减序列
            if (i2 == j2) {
                while (true) {
                    if (j2 == word2.length()) {
                        break;
                    }
                    j2 ++;
                    if (j2 == word2.length() || word2.charAt(j2) < word2.charAt(j2-1)) {
                        break;
                    }
                }
            }
            //比较两个序列，选大的，如果相同看序列后面的字符大小
            int temp1 = i1,temp2 = i2;
            while (true) {
                if ((temp2 >= j2 && temp1 < j1) || temp2 >= word2.length()) {
                    w1 = true;
                    break;
                }
                if ((temp1 >= j1 && temp2 < j2) || temp1 >= word1.length()) {
                    w1 = false;
                    break;
                }

                if (word1.charAt(temp1) > word2.charAt(temp2)) {
                    w1 = true;
                    break;
                }
                if (word1.charAt(temp1) < word2.charAt(temp2)) {
                    w1 = false;
                    break;
                }
                if (word1.charAt(temp1) == word2.charAt(temp2)) {
                    temp1 ++;
                    temp2 ++;
                }
            }
            //把对应的序列写入返回的字符串
            if (w1) {
                while(i1 < j1) {
                    charArr[i] = word1.charAt(i1);
                    i ++;
                    i1++;
                }
            } else {
                while(i2 < j2) {
                    charArr[i] = word2.charAt(i2);
                    i ++;
                    i2++;
                }
            }
        }

        return String.valueOf(charArr);
    }
}
