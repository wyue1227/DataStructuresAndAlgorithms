package com.yue.season1.class05;

import com.yue.season1.class05.circle.MyCircleDeque;
import com.yue.season1.class05.circle.MyCircleQueue;

public class Main {

    public static void main(String[] args) {
        // testQueue();
//        testDeque();
        testMyCircleQueue();
//        testMyCircleDeque();
    }

    public static void testQueue() {
        IQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);

        System.out.println(queue.getTop());

        Integer top = queue.poll();
        System.out.println(top);
        System.out.println(queue.getTop());

        queue.remove();
        System.out.println(queue.peek());
        try {
            System.out.println(queue.getTop());
        } catch (Exception e) {
            System.out.println("getTop == null");
        }
    }

    public static void testDeque() {
        IDeque<Integer> deque = new MyDeque<Integer>();
        deque.enQueueFront(0);
        deque.enQueueFront(-1);
        deque.enQueueRear(1);

        // size=3, [null_-1_0, -1_0_1, 0_1_null]
        System.out.println(deque);

        // -1
        System.out.println(deque.front());

        // 1
        System.out.println(deque.rear());

        // -1
        System.out.println(deque.deQueueFront());

        // 1
        System.out.println(deque.deQueueRear());

        deque.deQueueFront();

        try {
            deque.deQueueFront();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            deque.deQueueRear();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void testMyCircleQueue() {
        MyCircleQueue<Integer> queue = new MyCircleQueue<>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        System.out.println(queue);
        // 15 16 17 18 19 5 6 7 8 9
        for (int i = 15; i < 23; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        while (!queue.isEmpty()) {
            queue.deQueue();
        }

        System.out.println(queue);
    }

    static void testMyCircleDeque() {
        MyCircleDeque<Integer> queue = new MyCircleDeque<>();

        // 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
        // capacity=22 size=20 front=20, [8, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, null, null, 10, 9]
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }
        System.out.println(queue);

        // 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
        // capacity=22 size=14 front=1, [null, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, null, null, null, null, null, null, null]
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }
        System.out.println(queue);

        queue.clear();
        System.out.println(queue);
//
//        // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
//        queue.enQueueFront(11);
//        queue.enQueueFront(12);
//        System.out.println(queue);
//        while (!queue.isEmpty()) {
//            System.out.println(queue.deQueueFront());
//        }
    }
}