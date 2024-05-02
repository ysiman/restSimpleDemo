package ru.home.restSimpleDemo.Test;

import static ru.home.restSimpleDemo.Helper.LogHelper.objectToJson;

public class Car implements Runnable {

    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        Bmw bmw = new Bmw("BMW X7");
        System.out.println("Привет из побочного потока! carName: "+ objectToJson(bmw));
    }
}
