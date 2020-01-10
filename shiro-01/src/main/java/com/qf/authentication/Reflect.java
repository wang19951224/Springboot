package com.qf.authentication;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        List<String> set = new ArrayList<>();
        set.add("你");
        set.add("好");
        set.add("呀");
        set.add("大");
        set.add("哥");
        for(String a: set){
            System.out.println(a);
        }
    }
}
