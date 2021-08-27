package com.yue.season1.class03;

public class Main {
    public static void main(String[] args) {

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
