package org.hildabur;

import org.hildabur.utils.ArgumentManager;
import org.hildabur.utils.FileManager;

public class Main {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        ArgumentManager argumentManager = new ArgumentManager();
        argumentManager.setFileManager(new FileManager());
        argumentManager.parseArguments(args);
        System.out.println(argumentManager);
    }
}