package com.yue.season1.class01;

import com.yue.util.TimeUtil;

/**
 * Fibonacci数列求和
 * 0, 1, 1, 2, 3, 5, 8, 13
 * 规律：前两位分别是0、1，后面每一位是前面两位的和。
 */
public class Fibonacci {

    public static long basicFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return basicFibonacci(num - 1) + basicFibonacci(num - 2);
    }

    public static long improvedFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        long first = 0;
        long second = 1;
        long sum = num;
        for (int i = 0; i < num - 1; i ++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {

        int num = 40;

        TimeUtil.check("basicFibonacci", new TimeUtil.Task() {
            @Override
            public void execute() {
                System.out.println(basicFibonacci(num));
            }
        });

        TimeUtil.check("improvedFibonacci", new TimeUtil.Task() {
            @Override
            public void execute() {
                System.out.println(improvedFibonacci(num));
            }
        });

    }

}
