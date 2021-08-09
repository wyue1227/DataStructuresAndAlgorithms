package com.yue.season1.class02;

/**
 * 简单测试类
 * @author 19745
 */
public class Main {

    public static void main(String[] args) {
        test();
//        testGCList();
//        testGCPersonList();
    }

    public static void test() {
        MyArrayList<GCPerson> persons = new MyArrayList<GCPerson>(1);
        persons.add(new GCPerson(0, "Jack0"));
        persons.add(new GCPerson(1, "Jack1"));
        persons.add(new GCPerson(2, "Jack2"));

        // size=3, [Person [age=0, name=Jack0], Person [age=1, name=Jack1], Person [age=2, name=Jack2]]
        System.out.println(persons);

        persons.add(0, new GCPerson(-1, "jack-1"));

        // size=4, [Person [age=-1, name=jack-1], Person [age=0, name=Jack0], Person [age=1, name=Jack1], Person [age=2, name=Jack2]]
        System.out.println(persons);

        // 0
        System.out.println(persons.indexOf(new GCPerson(-1, "jack-1")));

        // Person [age=-1, name=jack-1]
        System.out.println(persons.get(0));

        // 4
        System.out.println(persons.size());

        // false
        System.out.println(persons.isEmpty());

        // true
        System.out.println(persons.contains(new GCPerson(-1, "jack-1")));

        // Person [age=2, name=Jack2]]
        System.out.println(persons.remove(3));

        // size=3, [Person [age=-1, name=jack-1], Person [age=0, name=Jack0], Person [age=1, name=Jack1]]
        System.out.println(persons);

        persons.add(3, new GCPerson(3, "jack3"));
        persons.set(3, new GCPerson(2, "jack2"));

        // size=4, [Person [age=-1, name=jack-1], Person [age=0, name=Jack0], Person [age=1, name=Jack1]], Person [age=2, name=Jack2]]
        System.out.println(persons);

        persons.clear();

        // size=0, []
        System.out.println(persons);

    }

    public static void testGCList() {
        test1();
        System.out.println("================================");
        test2();
        System.out.println("================================");
        test3();
        System.out.println("================================");
        test4();
    }

    public static void testGCPersonList() {
        testPerson1();
        System.out.println("================================");
        testPerson2();
        System.out.println("================================");
        testPerson3();
        System.out.println("================================");
        testPerson4();
    }

    public static void test1() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(1);
        for (int i = 0; i < 10000000; i ++) {
            myArrayList.add(i);
        }
        myArrayList.clear();
        System.gc();
    }

    public static void test2() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(1);
        for (int i = 0; i < 10000000; i ++) {
            myArrayList.add(i);
        }
        myArrayList.clear2();
        System.gc();
    }

    static void test3() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(1);
        for (int i = 0; i < 10000000; i ++) {
            myArrayList.add(i);
        }
        myArrayList.clear3();
        System.gc();
    }

    static void test4() {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(1);
        for (int i = 0; i < 10000000; i ++) {
            myArrayList.add(i);
        }
        myArrayList = null;
        System.gc();
    }

    static void testPerson1() {
        MyArrayList<GCPerson> persons  = new MyArrayList<>();
        for (int i = 0; i < 10000000; i ++) {
            persons.add(new GCPerson(i, "Jack"));
        }
        persons.clear();
        System.gc();
    }

    static void testPerson2() {
        MyArrayList<GCPerson> persons  = new MyArrayList<>();
        for (int i = 0; i < 10000000; i ++) {
            persons.add(new GCPerson(i, "Jack"));
        }
        persons.clear2();
        System.gc();
    }

    static void testPerson3() {
        MyArrayList<GCPerson> persons  = new MyArrayList<>();
        for (int i = 0; i < 10000000; i ++) {
            persons.add(new GCPerson(i, "Jack"));
        }
        persons.clear3();
        System.gc();
    }

    static void testPerson4() {
        MyArrayList<GCPerson> persons  = new MyArrayList<>();
        for (int i = 0; i < 10000000; i ++) {
            persons.add(new GCPerson(i, "Jack"));
        }
        persons = null;
        System.gc();
    }
}
