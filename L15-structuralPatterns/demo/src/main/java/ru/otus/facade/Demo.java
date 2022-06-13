package ru.otus.facade;

public class Demo {
    public static void main(String[] args) {
        var systemA = new HellSystemA();
        var systemB = new HellSystemB();

        var facade = new Facade(systemA, systemB);
        facade.simpleAction();
    }
}
