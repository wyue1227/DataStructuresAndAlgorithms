package com.yue.util;

import java.time.LocalDateTime;

public class TimeUtil {

    public interface Task {
        void execute();
    }

    public static void check(String title, Task task) {
        if (task == null) {
            return;
        }
        title = (title == null) ? "" : ("[" + title + "]");
        System.out.println(title);
        System.out.println("开始：" + LocalDateTime.now());
        long beginTime = System.currentTimeMillis();
        task.execute();
        long endTime = System.currentTimeMillis();
        System.out.println("结束：" + LocalDateTime.now());
        double delta = (endTime - beginTime) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("=========");

    }
}
