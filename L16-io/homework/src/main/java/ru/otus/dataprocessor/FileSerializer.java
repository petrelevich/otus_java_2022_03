package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileSerializer implements Serializer {
    String jsonResult;
    ObjectMapper mapper = new ObjectMapper();

    public FileSerializer(String fileName) throws IOException {

        var file = new File(fileName);
        mapper.writeValue(file, jsonResult);

    }

    @Override
    public String serialize(Map<String, Double> data) throws IOException {

        //Сортируем изначальный map
        Map<String, Double> sortedMap = new TreeMap<>(data);
        sortedMap.entrySet().forEach(System.out::println);
//формирует результирующий json и сохраняет его в файл
        jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(sortedMap);
        var file = new File(String.format("outputData.json"));
        mapper.writeValue(file, jsonResult);
        System.out.println(jsonResult);
        return jsonResult;
    }
}
