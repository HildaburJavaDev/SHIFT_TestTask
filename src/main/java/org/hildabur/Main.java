package org.hildabur;

import org.hildabur.services.FileService;
import org.hildabur.utils.ArgumentManager;
import org.hildabur.utils.ArgumentStorage;

public class Main {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        ArgumentManager argumentManager = new ArgumentManager();
        argumentManager.setArgumentStorage(new ArgumentStorage());
        argumentManager.parseArguments(args);
        System.out.println(argumentManager);
        FileService fileService = new FileService(argumentManager.getArgumentStorage());
        fileService.openFiles(argumentManager.isOptionS(), argumentManager.isOptionF());
    }
}