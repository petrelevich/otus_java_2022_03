package ru.otus.bridge;

public class Demo {
    public static void main(String[] args) {
        var card1 = new CreditCard(new VisaPS());
        card1.info();

        var card2 = new DebitCard(new MastercardPS());
        card2.info();

        var card3 = new DebitCard(new MirPS());
        card3.info();
    }
}
