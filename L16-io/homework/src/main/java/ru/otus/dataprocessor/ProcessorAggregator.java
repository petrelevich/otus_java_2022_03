package ru.otus.dataprocessor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.otus.model.Measurement;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class ProcessorAggregator implements Processor {


    @Override
    public Map<String, Double> process(List<Measurement> data) {
        //группирует выходящий список по name, при этом суммирует поля value
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ArrayList<String> list = new ArrayList<String>();

        String[] wordsArray = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {

            wordsArray[i] = String.valueOf(data.get(i));
            Measurement measurement = gson.fromJson(wordsArray[i], Measurement.class);
            list.add(measurement.getName() + "=" + measurement.getValue());

            System.out.println(list);

        }

        Map<String, Double> result = list.stream()
                .map(e -> e.split("="))
                .collect(groupingBy(e -> e[0],
                        summingDouble(e -> Double.parseDouble(e[1]))));
        System.out.println(result);

        return result;
    }

}
