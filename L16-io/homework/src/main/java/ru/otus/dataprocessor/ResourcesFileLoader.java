package ru.otus.dataprocessor;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.Json;
import jakarta.json.JsonStructure;
import ru.otus.model.Measurement;


import java.io.IOException;

import java.util.List;

public class ResourcesFileLoader implements Loader {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Measurement> list = null;

    public ResourcesFileLoader(String fileName) {
        load();
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат

        try (var jsonReader = Json.createReader(ResourcesFileLoader.class.getClassLoader().getResourceAsStream("inputData.json"))) {
            JsonStructure jsonFromTheFile = jsonReader.read();
            list = objectMapper.readValue(String.valueOf(jsonFromTheFile), List.class);
            System.out.println(list);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
