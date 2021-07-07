package com.yue;

import com.yue.util.TimeUtil;

public class Main {

    public static void main(String[] args) {
        TimeUtil.check("testAdd", new TimeUtil.Task() {
            @Override
            public void execute() {
                long res = 0;
                for (long i = 0; i < 1000000000; i ++) {
                    res += i;
                }
                System.out.println(res);
            }
        });
    }
}
