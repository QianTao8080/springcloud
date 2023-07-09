package com.example.order.test.waitnotify;

public class Product {

    private int num;

    public void add() {
        num++;
    }

    public void use() {
        num--;
    }

    public int getNum() {
        return num;
    }
}
