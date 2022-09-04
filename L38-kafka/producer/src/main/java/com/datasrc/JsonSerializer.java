package com.datasrc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JsonSerializer<T> implements Serializer<T> {
    public static final String OBJECT_MAPPER = "objectMapper";
    private final String encoding = StandardCharsets.UTF_8.name();
    private ObjectMapper mapper;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        mapper = (ObjectMapper) configs.get(OBJECT_MAPPER);
        if (mapper == null) {
            throw new IllegalArgumentException("config property OBJECT_MAPPER was not set");
        }
    }

    @Override
    public byte[] serialize(String topic, T data) {
        try {
            if (data == null) {
                return null;
            } else {
                return mapper.writeValueAsString(data).getBytes(encoding);
            }
        } catch (Exception e) {
            throw new SerializationException("Error when serializing StringValue to byte[] ", e);
        }
    }
}
