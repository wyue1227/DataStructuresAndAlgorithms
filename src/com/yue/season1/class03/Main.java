package com.yue.season1.class03;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        circleTest();
//        updateTest();
    }

    private static void circleTest() {
        MyCircleLinkedList<Integer> list = new MyCircleLinkedList();
        list.add(0);
        list.add(1);
        list.add(0, -1);
        list.add(list.size(), 2);

        // size=4, [2_-1_0, -1_0_1, 0_1_2, 1_2_-1]
        System.out.println(list);
        // -1
        System.out.println(list.getFirst());
        // 2
        System.out.println(list.getLast());

        list.remove(0);

        // size=3, [2_0_1, 0_1_2, 1_2_0]
        System.out.println(list);
        // 0
        System.out.println(list.getFirst());
        // 2
        System.out.println(list.getLast());

        list.remove(list.size() - 1);

        // size=2, [1_0_1, 0_1_0]
        System.out.println(list);
        // 0
        System.out.println(list.getFirst());
        // 1
        System.out.println(list.getLast());

        list.remove(0);
        list.remove(0);

        // size=2, [1_0_1, 0_1_0]
        System.out.println(list);

        list.addFirst(0);
        list.addFirst(-1);

        // size=2, [0_-1_0, -1_0_-1]
        System.out.println(list);
    }

    private static void updateTest() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(0, -2);
        list.add(1, -1);

        // size=4, [null_-2_-1, -2_-1_0, -1_0_1, 0_1_null]
        System.out.println(list);

        // -2
        System.out.println(list.getFirst());

        // 1
        System.out.println(list.getLast());


        list.remove(0);
        list.remove(list.size() - 1);
        list.add(1);
        list.remove(1);

        // size=2, [null_-1_1, -1_1_null]
        System.out.println(list);

        list.addFirst(-2);
        list.addLast(2);

        // size=4, [null_-2_-1, -2_-1_1, -1_1_2, 1_2_null]
        System.out.println(list);
    }

    private static void basicTest() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        // size=3, [0, 1, 2]
        System.out.println(list);

        list.remove(0);

        // size=2, [1, 2]
        System.out.println(list);

        list.add(3);

        // size=3, [1, 2, 3]
        System.out.println(list);

        // size=3, [1, 2]
        list.remove(list.size() - 1);
        System.out.println(list);

        list.add(null);
        int nullIndex = list.indexOf(null);

        // size=3, [1, 2, null]
        System.out.println(list);

        // 2
        System.out.println(nullIndex);
    }
}
