package ru.otus.decorator;


public class Demo {
    public static void main(String[] args) {
        var ds = new DataSourceImpl();
        printer(ds);

        printer(new DataSourceDecoratorAdder(ds));
        printer(new DataSourceDecoratorMultiplicator(ds));
        printer(new DataSourceDecoratorAdder(new DataSourceDecoratorMultiplicator(ds)));

    }

    private static void printer(DataSource ds) {
        System.out.println(ds.getInteger());
    }
}
