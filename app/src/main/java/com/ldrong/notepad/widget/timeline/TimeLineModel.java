package com.ldrong.notepad.widget.timeline;


public class TimeLineModel {
    private String name;
    private int age;

    public TimeLineModel() {

    }

    public TimeLineModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
