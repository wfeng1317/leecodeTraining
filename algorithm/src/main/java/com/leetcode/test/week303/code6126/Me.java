package com.leetcode.test.week303.code6126;

import java.util.HashMap;
import java.util.TreeSet;

public class Me {
    static class FoodRatings {

        public HashMap<String, TreeSet<Node>> map = new HashMap<>();
        public HashMap<String, String> foodMap = new HashMap<>();
        public HashMap<String, Node> nodeMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for(int i = 0; i < foods.length; i++){
                Node cur = new Node(foods[i], ratings[i]);
                nodeMap.put(foods[i], cur);
                foodMap.put(foods[i], cuisines[i]);
                if(!map.containsKey(cuisines[i])){
                    map.put(cuisines[i], new TreeSet<Node>((n1, n2) -> {
                        return n1.rate == n2.rate ? n1.food.compareTo(n2.food) : n2.rate - n1.rate;
                    }));
                }
                map.get(cuisines[i]).add(cur);
            }

        }

        public void changeRating(String food, int newRating) {
            TreeSet<Node> curSet = map.get(foodMap.get(food));
            curSet.remove(nodeMap.get(food));
            Node cur = new Node(food, newRating);
            curSet.add(cur);
            nodeMap.put(food, cur);
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).first().food;
        }

        public static class Node{
            public String food;
            public int rate;
            public Node(String f, int r){
                food = f;
                rate = r;
            }
        }
    }
}
