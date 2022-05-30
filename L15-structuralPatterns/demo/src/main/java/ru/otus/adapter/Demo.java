package ru.otus.adapter;

public class Demo {
    public static void main(String[] args) {
        new Demo().usePattern();
        new Demo().alternative();
    }

    public void usePattern() {
        var rotaryHammer = new RotaryHammer();
        var drill = new Drill();
        rotaryHammer.drill(new SDSadapter(drill));
    }

    public void alternative() {
        var rotaryHammer = new RotaryHammer();
        var drill = new Drill();
        rotaryHammer.drill(() -> System.out.println(drill));
    }
}
