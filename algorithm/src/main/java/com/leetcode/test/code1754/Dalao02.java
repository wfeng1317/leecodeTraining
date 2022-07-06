package com.leetcode.test.code1754;

public class Dalao02 {
    public String largestMerge(String word1, String word2) {
        int i = 0, j = 0;
        StringBuffer merge = new StringBuffer();
        int len1 = word1.length(), len2 = word2.length();
        while (i < len1 || j < len2) {
            if (word1.substring(i).compareTo(word2.substring(j)) < 0)
                merge.append(word2.charAt(j++));
            else merge.append(word1.charAt(i++));
        }
        return merge.toString();
    }
}
