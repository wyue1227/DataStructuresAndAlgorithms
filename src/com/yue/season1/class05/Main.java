package com.yue.season1.class05;

public class Main {

    public static void main(String[] args) {
        // testQueue();
        testDeque();
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
}