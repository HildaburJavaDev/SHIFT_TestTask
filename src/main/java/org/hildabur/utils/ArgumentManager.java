package org.hildabur.utils;

import lombok.Getter;

@Getter
public class ArgumentManager {
    private boolean optionO;
    private boolean optionP;
    private boolean optionA;
    private ArgumentStorage argumentStorage;

    public ArgumentManager() {
        optionO = false;
        optionP = false;
        optionA = false;
    }

    public void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a", "-A" -> optionA = true;
                case "-o", "-O" -> {
                    if(optionO) {
                        Notificator.printErrorMessage("Option -o is already exists. Skipped");
                        i++;
                        continue;
                    }

                    optionO = true;
                    argumentStorage.setPathResultFiles(args[++i]);
                }
                case "-p", "-P" -> {
                    if(optionP) {
                        Notificator.printErrorMessage("Option -p is already exists. Skipped");
                        i++;
                        continue;
                    }

                    optionP = true;
                    argumentStorage.setPrefixFileName(args[++i]);
                }
                default -> argumentStorage.addSourceFile(args[i]);
            }
        }
    }

    public void setArgumentStorage(ArgumentStorage argumentStorage) {
        this.argumentStorage = argumentStorage;
    }

    public ArgumentStorage getArgumentStorage() {
        return argumentStorage;
    }

    @Override
    public String toString() {
        return "ArgumentManager{" +
                "optionO=" + optionO +
                ", optionP=" + optionP +
                ", optionA=" + optionA + '\''+  argumentStorage.toString() +
                '}';
    }
}
