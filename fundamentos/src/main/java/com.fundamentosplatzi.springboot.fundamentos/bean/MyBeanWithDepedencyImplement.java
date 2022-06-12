package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDepedencyImplement implements  MyBeanWithDepedency{

    MyOperation myOperation;

    public MyBeanWithDepedencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        var number = 7;
        System.out.println(myOperation.suma(number));
        System.out.println("Hola desde printWithDependency, la implementación  de un Bean con dependencia.");
    }
}
