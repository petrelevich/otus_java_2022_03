package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.Map;


public class FileSerializer implements Serializer {

    private final ObjectMapper mapper = new ObjectMapper();
    private final File files;

    public FileSerializer(String fileName) {

        files = new File(fileName);

    }

    @Override
    public void serialize(Map<String, Double> data) {


//сохраняет в файл
        try {
            var file = new File(String.valueOf(files));
            mapper.writeValue(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
