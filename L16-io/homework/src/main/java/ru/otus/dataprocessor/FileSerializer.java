package ru.otus.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.Map;


public class FileSerializer implements Serializer {

    private final ObjectMapper mapper = new ObjectMapper();
    private final File files;

    public FileSerializer(String fileName) throws IOException {

        files = new File(fileName);


    }

    @Override
    public String serialize(Map<String, Double> data) throws IOException {


//сохраняет в файл

        var file = new File(String.valueOf(files));
        mapper.writeValue(file, data);

        return null;
    }
}
