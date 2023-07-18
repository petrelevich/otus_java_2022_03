package ru.otus.dataprocessor;


import java.io.IOException;
import java.util.Map;

public interface Serializer {

    String serialize(Map<String, Double> data) throws IOException;
}
