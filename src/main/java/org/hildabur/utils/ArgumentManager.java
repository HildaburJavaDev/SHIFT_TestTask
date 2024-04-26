package org.hildabur.utils;

import lombok.Getter;

@Getter
public class ArgumentManager {
    private boolean optionO;
    private boolean optionP;
    private boolean optionA;

    public ArgumentManager() {
        optionO = false;
        optionP = false;
        optionA = false;
    }

    public void parseArguments(String[] args) {
        for (String s : args) {
            switch (s) {
                case "a", "A" -> optionA = true;
                case "o", "O" -> optionO = true;
                case "p", "P" -> optionP = true;
                default -> System.err.println("Invalid argument");
            }
        }
    }
}
