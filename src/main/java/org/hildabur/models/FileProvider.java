package org.hildabur.models;

import lombok.Getter;
import org.hildabur.enums.TypesOfString;

import java.io.File;
import java.io.IOException;

@Getter
public class FileProvider {
    private final String floatFilePath;
    private final String integersFilePath;
    private final String stringsFilePath;

    public FileProvider(String path, String prefix) {
        integersFilePath = path + prefix + "integers.txt";
        floatFilePath = path + prefix + "floats.txt";
        stringsFilePath = path + prefix + "strings.txt";
    }

    public void createFile(TypesOfString typeOfString) {
        File file = null;
        switch (typeOfString) {
            case INTEGER ->
                    file = new File(integersFilePath);
            case FLOAT ->
                    file = new File(floatFilePath);
            case STRING ->
                    file = new File(stringsFilePath);
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
}
