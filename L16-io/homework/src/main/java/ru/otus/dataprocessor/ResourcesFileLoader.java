package ru.otus.dataprocessor;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.Json;
import jakarta.json.JsonStructure;
import ru.otus.model.Measurement;


import java.io.File;
import java.io.IOException;

import java.util.List;

public class ResourcesFileLoader implements Loader {
    private final ObjectMapper objectMapper = new ObjectMapper();
    File file;

    public ResourcesFileLoader(String fileName) throws JsonProcessingException {
        file = new File(fileName);
        load();
    }

    @Override
    public List<Measurement> load() throws JsonProcessingException {
        //читает файл, парсит и возвращает результат
        var jsonReader = Json.createReader(ResourcesFileLoader.class.getClassLoader().getResourceAsStream("inputData.json"));
            JsonStructure jsonFromTheFile = jsonReader.read();
        List<Measurement> list = objectMapper.readValue(String.valueOf(jsonFromTheFile), List.class);


        return list;
    }
}
