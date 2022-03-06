package com.zhang.dao;

import java.util.HashMap;

public class TestCopilot {
    public static void main(String[] args) {
        // 测试copilot
        int[] list = new int[]{3, 2, 34, 5, 6, 7, 8, 9, 10};
        TestCopilot test = new TestCopilot();
        test.print(list);
        test.multiply(list);
        test.sum(list);
        System.out.println(test.listToMap(list));
    }

    // 输出数组的下标和值
    public void print(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println("list[" + i + "] = " + list[i]);
        }
    }

    // 计算数组中所有数字的乘积
    public void multiply(int[] list) {
        int result = 1;
        for (int i = 0; i < list.length; i++) {
            result *= list[i];
        }
        System.out.println("result = " + result);
    }

    // 计算数组中所有数字之和
    public void sum(int[] list) {
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            result += list[i];
        }
        System.out.println("result = " + result);
    }

    // 将数组转换为字典,字典的键为数字在数组中的下表,值为元素的值
    public HashMap<Integer, Integer> listToMap(int[] list) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.length; i++) {
            map.put(i, list[i]);
        }
        return map;
    }
}
