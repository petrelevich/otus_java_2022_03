package ru.otus.bytecodes;

/*
javap -c -verbose OneOne.class
*/
public class OneOne {
    int add(int x, int y) {
        boolean r = true;
        return x + y;
    }
}
