package com.yue.season1.class07;

import com.yue.season1.class07.print.BinaryTrees;

public class Main {

    public static void main(String[] args) {
        Integer dataArray[] = new Integer[]{
          7, 4, 9, 2, 5, 8, 11, 3, 1, 12
        };
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (Integer data: dataArray) {
            tree.add(data);
        }
        BinaryTrees.println(tree);
        System.out.println(tree.preorderTraversal());
        System.out.println(tree.inorderTraversal());
        System.out.println(tree.postorderTraversal());
        System.out.println(tree.levelOrderTraversal());
    }

}
