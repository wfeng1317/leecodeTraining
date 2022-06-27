package com.leetcode.test.code1125;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Me {

    List<Integer> minPeople  = null;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        //先用哈希表存放技能所需要出现的次数
        int skillsCount = req_skills.length;
        int target = 0;
        Map<String, Integer> skillsMap = new HashMap<>();
        for(int i = 0; i < req_skills.length; i++){
            skillsMap.put(req_skills[i], i);
            target |= (1 << i);
        }
        int[] eachSkills = new int[people.size()];
        for(int i = 0; i < people.size(); i++){
            for(int j = 0; j < people.get(i).size(); j++){
                eachSkills[i] |= (1 << (skillsCount - 1 - skillsMap.get(people.get(i).get(j))));
            }
        }
        List<Integer> used = new ArrayList<>();
        process(eachSkills, 0, used, 0, target);
        int[] res = new int[minPeople.size()];
        for(int i = 0; i < minPeople.size(); i++){
            res[i] = minPeople.get(i);
        }
        return res;
    }

    public void process(int[] eachSkills, int pre, List<Integer> used, int cur, int target){
        if(pre == target){
            //所有技能都具备，收集答案
            if(minPeople == null || used.size() < minPeople.size()){
                minPeople = new ArrayList<>(used);
            }
            return;
        }
        if(cur >= eachSkills.length || (minPeople != null && used.size() >= minPeople.size())){
            return;
        }
        int start = pre;
        //情况1，不把cur加入团队
        process(eachSkills, start, used, cur + 1, target);
        //情况2，把cur加入团队
        int curSkills = eachSkills[cur];
        if(curSkills == 0 || (curSkills | start) == start){
            return;
        }
        start |= curSkills;
        used.add(cur);
        process(eachSkills, start, used, cur + 1, target);
        used.remove(used.size() - 1);
    }
}
