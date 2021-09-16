package com.yue.season1.class05;

public class Main {

    public static void main(String[] args) {

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
}