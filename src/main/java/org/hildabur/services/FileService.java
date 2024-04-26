package org.hildabur.services;

import org.hildabur.middleware.DirectoryExistenceCheckerMiddleware;
import org.hildabur.utils.ArgumentStorage;

public class FileService {
    ArgumentStorage argumentStorage;

    public FileService(ArgumentStorage argumentStorage) {
        this.argumentStorage = argumentStorage;
    }

    public void createOutputFiles() {
        if (!DirectoryExistenceCheckerMiddleware.check(argumentStorage.getPathResultFiles())) System.out.println("Не существует");
//        String currentDirectory = System.getProperty("user.dir");
//        System.out.println("Текущая директория: " + currentDirectory + "\n Ожидаемая " + currentDirectory + argumentStorage.getPathResultFiles());
    }

}
