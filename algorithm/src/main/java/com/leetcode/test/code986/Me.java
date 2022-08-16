package com.leetcode.test.code986;

import java.util.ArrayList;
import java.util.List;

public class Me {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fn = firstList.length;
        int sn = secondList.length;
        if(fn == 0 || sn == 0){
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        int fi = 0;
        int fl = firstList[fi][0];
        int fr = firstList[fi][1];
        int si = 0;
        int sl = secondList[si][0];
        int sr = secondList[si][1];
        while(true){
            int[] temp = new int[2];
            if(fl <= sl){
                if(fr >= sl && fr <= sr){
                    temp[0] = sl;
                    temp[1] = fr;
                    list.add(temp);
                    if(fr == sr){
                        si++;
                        if(si == sn){
                            break;
                        }
                        sl = secondList[si][0];
                        sr = secondList[si][1];
                    }else{
                        sl = temp[1] + 1;
                    }
                    fi++;
                    if(fi == fn){
                        break;
                    }
                    fl = firstList[fi][0];
                    fr = firstList[fi][1];
                }else if(fr > sr){
                    temp[0] = sl;
                    temp[1] = sr;
                    list.add(temp);
                    fl = temp[1] + 1;
                    si++;
                    if(si == sn){
                        break;
                    }
                    sl = secondList[si][0];
                    sr = secondList[si][1];
                }else{
                    fi++;
                    if(fi == fn){
                        break;
                    }
                    fl = firstList[fi][0];
                    fr = firstList[fi][1];
                }
            }else{
                if(sr >= fl && sr <= fr){
                    temp[0] = fl;
                    temp[1] = sr;
                    list.add(temp);
                    if(fr == sr){
                        fi++;
                        if(fi == fn){
                            break;
                        }
                        fl = firstList[fi][0];
                        fr = firstList[fi][1];
                    }else{
                        fl = temp[1] + 1;
                    }
                    si++;
                    if(si == sn){
                        break;
                    }
                    sl = secondList[si][0];
                    sr = secondList[si][1];
                }else if(sr > fr){
                    temp[0] = fl;
                    temp[1] = fr;
                    list.add(temp);
                    sl = temp[1] + 1;
                    fi++;
                    if(fi == fn){
                        break;
                    }
                    fl = firstList[fi][0];
                    fr = firstList[fi][1];
                }else{
                    si++;
                    if(si == sn){
                        break;
                    }
                    sl = secondList[si][0];
                    sr = secondList[si][1];
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
