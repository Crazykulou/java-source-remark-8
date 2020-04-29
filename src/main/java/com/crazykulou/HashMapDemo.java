package com.crazykulou;

import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.List;

public class HashMapDemo {
    public static void main(String[] args) {
        String key = "78979879878798";
        int h;
        int s = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(s);
    }
}
