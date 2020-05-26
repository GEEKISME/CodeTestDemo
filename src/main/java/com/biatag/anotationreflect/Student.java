package com.biatag.anotationreflect;

@MyAnno
public class Student {
    @MyAnno(name = "bb")
    int age;
    @MyAnno
    String address;
    @MyAnno
    public void sayHello(String name){
        System.out.println("hello"+name);
    }

    private void sayBye(String name){
        System.out.println("bye"+name);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int age, String address) {
        this.age = age;
        this.address = address;
    }

    public Student(){}
}
