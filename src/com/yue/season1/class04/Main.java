package com.yue.season1.class04;


import java.util.EmptyStackException;

import static com.yue.util.PrintUtil.print;

public class Main {

    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(1);

        // 1
        print(stack.peek());

        Integer tmp = stack.pop();

        // 1
        print(tmp);

        // 0
        print(stack.peek());

        stack.pop();

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            print("empty check pass");
        }


    }
}
