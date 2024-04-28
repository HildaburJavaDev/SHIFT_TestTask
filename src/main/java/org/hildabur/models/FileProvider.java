package org.hildabur.models;

import lombok.Data;
import org.hildabur.enums.TypesOfString;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// класс для работы с файлами
@Data
public class FileProvider {
    private final String floatFilePath;
    private final String integersFilePath;
    private final String stringsFilePath;

//     конструктор, определяющий пути к результирующим файлам
    public FileProvider(String path, String prefix) {
        integersFilePath = path + prefix + "integers.txt";
        floatFilePath = path + prefix + "floats.txt";
        stringsFilePath = path + prefix + "strings.txt";
    }

//     создание файлов, в зависимости от типа строки, полученной в методе класса fileService
    public void createFile(TypesOfString typeOfString) {
        File file = null;
        switch (typeOfString) {
            case INTEGER -> file = new File(integersFilePath);
            case FLOAT -> file = new File(floatFilePath);
            case STRING -> file = new File(stringsFilePath);
        }
        try {
            if (file != null) {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            }
        } catch (IOException exception) {
            System.out.println("Ошибка при создании файла" + exception.getMessage());
        }
    }

//    запись в файл
    public void writeToFile(TypesOfString typeOfString, boolean optionA, String str) throws IOException {
        Path path;
        switch (typeOfString) {
            case INTEGER -> path = Path.of(integersFilePath);
            case FLOAT -> path = Path.of(floatFilePath);
            case STRING -> path = Path.of(stringsFilePath);
            default -> {
                return;
            }
        }
        if (!optionA)
            Files.write(path, new byte[0]);
        Files.write(path, (str + System.lineSeparator()).getBytes(),
                        StandardOpenOption.APPEND);
    }
}
