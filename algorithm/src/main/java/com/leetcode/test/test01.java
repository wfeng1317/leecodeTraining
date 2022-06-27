package com.leetcode.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigInteger;
import java.util.*;

public class test01 {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println(b - a);

        Integer[] count = new Integer[] { 1, 2 };
        Arrays.sort(count, (e1, e2) -> e2 - e1);

        String s1 = "abcdefghijk";
        s1 = s1.substring(0, 3) + s1.substring(6, 8);
        System.out.println(s1);




    }
}
