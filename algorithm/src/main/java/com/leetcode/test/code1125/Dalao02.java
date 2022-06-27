package com.leetcode.test.code1125;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dalao02 {

    //记录最小团队人数
    int min=Integer.MAX_VALUE;
    //人数最多60人所以用long即可表示任意一种选择方案
    long minStatue=0;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //建立下标与需要的技能的映射,同时记录目标状态
        int aimStatue=0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<req_skills.length;i++){
            map.put(req_skills[i],i);
            aimStatue=aimStatue|(1<<i);
        }
        //用二进制记录每个人掌握的技能
        int[] dp=new int[people.size()];
        int i=0;
        for(List<String> list:people){
            int bit=0;
            for(String s:list){
                bit=bit|(1<<map.get(s));
            }
            dp[i]=bit;
            i++;
        }
        //排除掉掌握技能是别人子集的人
        for(i=0;i<dp.length;i++){
            if(dp[i]==-1)continue;
            for(int i1=0;i1<dp.length;i1++){
                if(i==i1)continue;
                if(dp[i1]==-1)continue;
                if((dp[i]|dp[i1])==dp[i]){
                    dp[i1]=-1;
                }
            }
        }
        //深搜穷举
        dfs(dp,0,aimStatue,0,0,0);
        //获取最小团队中选了哪些人
        int[] ans=new int[min];
        int index=0;
        int ansInd=0;
        long temp=minStatue;
        while (temp!=0){
            if((temp&1)!=0)ans[ansInd++]=index;
            index++;
            temp>>=1;
        }
        return ans;
    }
    private void dfs(int[] dp,long selected,int aimStatue,int curStatue,int count,int start){
        //若团队掌握技能达到要求则进行更新
        if(curStatue==aimStatue){
            if(count<min){
                min=count;
                minStatue=selected;
            }
            return;
        }
        //最小值剪枝
        if(count>=min)return;
        for(int i=start;i<dp.length;i++){
            //已被排除的不考虑
            if(dp[i]==-1)continue;
            //被选过的不考虑
            if((selected&(1L<<i))!=0)continue;
            //在当前团队中，此人所掌握的技能若都已存在则不考虑此队员
            if((curStatue|dp[i])==curStatue)continue;
            //将此队员入选并更新当前团队所掌握技能
            dfs(dp, selected|(1L<<i), aimStatue, curStatue|dp[i], count+1,i+1);
        }
    }
}
