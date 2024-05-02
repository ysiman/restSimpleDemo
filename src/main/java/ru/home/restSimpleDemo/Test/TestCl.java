package ru.home.restSimpleDemo.Test;

public class TestCl {
    public static void main(String[] args) {
        System.out.println("hello");
        Car car = new Car();
        for(int i = 0; i< 10000; i++){
            Thread myThready = new Thread(car);
            myThready.start();
        }
        System.out.println("success");
    }
}
