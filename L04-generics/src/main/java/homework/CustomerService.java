package homework;


import java.io.*;
import java.util.*;


public class CustomerService implements Serializable{

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
   /* Map<Customer, String> map = new HashMap<>();*/
    TreeMap<Customer, String> map = new TreeMap<Customer, String>(new CustomerS());

    public CustomerService() throws IOException {
    }

    public Map.Entry<Customer, String> getSmallest() throws IOException, ClassNotFoundException {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk

        List <Map.Entry<Customer, String>> values = new ArrayList(map.entrySet());

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(map);

        FileInputStream fileInputStream = new FileInputStream("D:\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        TreeMap saved = (TreeMap) objectInputStream.readObject();
        List <Map.Entry<Customer, String>> values2 = new ArrayList(saved.entrySet());
        return values2.get(0);

        //старое решение
     /*   List <Map.Entry<Customer, String>> values = new ArrayList(map.entrySet());

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
*/

    }


    public Map.Entry<Customer, String> getNext(Customer customer) throws IOException, ClassNotFoundException {
        add(customer, "Data4");
        List <Map.Entry<Customer, String>> values = new ArrayList(map.entrySet());
        /*Collections.sort(values, new Comparator<Map.Entry<Customer, String>>() {

            @Override
            public int compare(Map.Entry<Customer, String> o1, Map.Entry<Customer, String> o2) {
                return Double.compare(o1.getKey().getScores(), o2.getKey().getScores());
            }
        });*/
        Map<Customer, String> sortedMap = new LinkedHashMap<>();
        for (Iterator<Map.Entry<Customer, String>> it = values.iterator(); it.hasNext();) {
            Map.Entry<Customer, String> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        List<Customer> keys = List.copyOf( sortedMap.keySet() );
        List <Map.Entry<Customer, String>> values2 = new ArrayList(sortedMap.entrySet());
        int ind = keys.indexOf(customer);
        int in = keys.size();
        if ((ind+1)<in){
        return values2.get(ind+1);
        } else {
            return null;
        }

    }

    public void add(Customer customer, String data) throws IOException, ClassNotFoundException {

        map.put(customer, data);




    }
    //новое решение
    public class CustomerS implements Comparator<Customer>, Serializable {
        @Override
        public int compare(Customer e1, Customer e2) {
            if(e1.getScores() > e2.getScores()){
                return 1;
            } else {
                return -1;
            }
        }
    }


}
