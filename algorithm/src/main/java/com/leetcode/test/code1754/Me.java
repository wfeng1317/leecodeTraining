package com.leetcode.test.code1754;

public class Me {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        String merge = "";
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1 < n1 && i2 < n2){
            if(word1.charAt(i1) > word2.charAt(i2)){
                merge += word1.charAt(i1++);
            }else if(word1.charAt(i1) < word2.charAt(i2)){
                merge += word2.charAt(i2++);
            }else{
                //当前位置相等
                if(i1 == n1 - 1 && i2 == n2 - 1){//若两边都到结尾了
                    merge += word1.charAt(i1++);
                }else if(i1 == n1 - 1 && i2 < n2 - 1){//i1到结尾了，加i2
                    merge += word2.charAt(i2++);
                }else if(i2 == n2 - 1 && i1 < n1 - 1){//i2到结尾了，加i1
                    merge += word1.charAt(i1++);
                }else{
                    int k1 = i1;
                    int k2 = i2;
                    while(k1 < n1 && k2 < n2){
                        if(word1.charAt(k1) != word2.charAt(k2)){
                            break;
                        }
                        k1++;
                        k2++;
                    }
                    if(k1 == n1){//k1越界
                        merge += word2.charAt(i2++);
                    }else if(k2 == n2){//k2越界
                        merge += word1.charAt(i1++);
                    }else {//比出胜负
                        if(word1.charAt(k1) < word2.charAt(k2)){
                            merge += word2.charAt(i2++);
                        }else{
                            merge += word1.charAt(i1++);
                        }
                    }
                }
            }
        }
        return merge + (i1 == n1 ? word2.substring(i2) : word1.substring(i1));
    }
}
