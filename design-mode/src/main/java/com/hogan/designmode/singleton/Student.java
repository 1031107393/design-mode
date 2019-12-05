package com.hogan.designmode.singleton;

/**
 * TODO
 * wujun
 * 2019/12/05 9:40
 */
public class Student {

    String name;

    Integer age;

    String address;

    Student friend;

    public Student() {
    }

    public Student(String name, Integer age, String address, Student friend) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getFriend() {
        return friend;
    }

    public void setFriend(Student friend) {
        this.friend = friend;
    }
}
