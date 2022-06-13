package ru.otus.adapter;


public class SDSadapter implements SDSdril {
    private final Drill drill;

    public SDSadapter(Drill drill) {
        this.drill = drill;
    }

    @Override
    public void action() {
        System.out.println(this.drill);
    }
}
