package homework;


import java.util.*;


public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    Map<Customer, String> map = new HashMap<>();


    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk

        List <Map.Entry<Customer, String>> values = new ArrayList(map.entrySet());

        Collections.sort(values, new Comparator<Map.Entry<Customer, String>>() {

            @Override
            public int compare(Map.Entry<Customer, String> o1, Map.Entry<Customer, String> o2) {
                return Double.compare(o1.getKey().getScores(), o2.getKey().getScores());
            }
        });
        Map<Customer, String> sortedMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<Customer, String>> it = values.iterator(); it.hasNext();) {
            Map.Entry<Customer, String> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        List<Map.Entry<Customer, String>> readOnly = Collections.unmodifiableList(values);


        return readOnly.get(0);


    }


    public Map.Entry<Customer, String> getNext(Customer customer) {
        add(customer, "Data4");
        List <Map.Entry<Customer, String>> values = new ArrayList(map.entrySet());
        Collections.sort(values, new Comparator<Map.Entry<Customer, String>>() {

            @Override
            public int compare(Map.Entry<Customer, String> o1, Map.Entry<Customer, String> o2) {
                return Double.compare(o1.getKey().getScores(), o2.getKey().getScores());
            }
        });
        Map<Customer, String> sortedMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<Customer, String>> it = values.iterator(); it.hasNext();) {
            Map.Entry<Customer, String> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        List<Customer> keys = List.copyOf( sortedMap.keySet() );
        int ind = keys.indexOf(customer);
        int in = keys.size();
        if ((ind+1)<in){

        return values.get(ind+1);
        } else {
            return null;
        }

    }

    public void add(Customer customer, String data) {
        map.put(customer, data);


    }
}
