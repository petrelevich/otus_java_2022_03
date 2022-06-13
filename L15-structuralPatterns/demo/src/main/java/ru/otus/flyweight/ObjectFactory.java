package ru.otus.flyweight;


public class ObjectFactory {
    private final HeavyCommonPart heavyCommonPart;

    public ObjectFactory() {
        heavyCommonPart = new HeavyCommonPart();
    }

    public ObjectOnLine create(int x) {
        return new ObjectOnLine(heavyCommonPart, x);
    }
}
