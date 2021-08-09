package com.yue.season1.class02;

/**
 * @author 19745
 */
public class GCPerson {
    private int age;
    private String name;

    public GCPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GCPerson) {
            GCPerson person  = (GCPerson) obj;
            return this.age == person.age;
        }
        return false;
    }
}
