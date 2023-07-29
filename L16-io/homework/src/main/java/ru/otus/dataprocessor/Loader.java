package ru.otus.dataprocessor;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.otus.model.Measurement;

import java.util.List;
//Унифицированный интерфейс для загрузки файлов
public interface Loader {

    List<Measurement> load();
}
