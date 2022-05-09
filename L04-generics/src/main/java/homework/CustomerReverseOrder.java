package homework;


import java.lang.reflect.Array;
import java.util.*;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    ArrayList<Customer> reverse = new ArrayList<Customer>();

    public void add(Customer customer) {
        reverse.add(customer);
    }

    public Customer take() {
        System.out.print(reverse);
        ArrayList<Customer> valuesList = new ArrayList(reverse);
        Collections.reverse(valuesList);
        Customer a = valuesList.get(0);
        reverse.remove(reverse.size()-1);
        return a; // это "заглушка, чтобы скомилировать"
        
    }
}
