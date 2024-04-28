package org.hildabur;

import org.hildabur.services.FileService;
import org.hildabur.utils.ArgumentManager;
import org.hildabur.utils.ArgumentStorage;

public class Main {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
//        создаем объект для работы с аргументами командной строки
        ArgumentManager argumentManager = new ArgumentManager();
//        установим argumentStorage, который хранит в себе аргументы командной строки
        argumentManager.setArgumentStorage(new ArgumentStorage());
//        парсим аргументы
        argumentManager.parseArguments(args);
        System.out.println(argumentManager);
//        объект для работы с файлами
        FileService fileService = new FileService(argumentManager.getArgumentStorage());
        fileService.openFiles();
    }
}