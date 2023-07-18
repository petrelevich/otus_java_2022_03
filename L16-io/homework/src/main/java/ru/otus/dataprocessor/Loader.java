package ru.otus.dataprocessor;

import ru.otus.model.Measurement;

import java.util.List;
//Унифицированный интерфейс для загрузки файлов
public interface Loader {

    List<Measurement> load();
}
