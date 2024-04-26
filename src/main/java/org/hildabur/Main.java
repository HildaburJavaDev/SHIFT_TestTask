package org.hildabur;

import org.hildabur.utils.ArgumentManager;

public class Main {
    public static void main(String[] args) {
        start(args);
    }

    private static void start(String[] args) {
        ArgumentManager argumentManager = new ArgumentManager();
        argumentManager.parseArguments(args);
    }
}