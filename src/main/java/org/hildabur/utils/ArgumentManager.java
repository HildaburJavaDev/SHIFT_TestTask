package org.hildabur.utils;

import lombok.Getter;

@Getter
public class ArgumentManager {
    private boolean optionO;
    private boolean optionP;
    private boolean optionA;
    private boolean optionS;
    private boolean optionF;
    private ArgumentStorage argumentStorage;

    public ArgumentManager() {
        optionO = false;
        optionP = false;
        optionA = false;
        optionS = false;
        optionF = false;
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
                case "-s", "-S" -> {
                    if (optionS) {
                        Notificator.printErrorMessage("Option -s is already exists. Skipped");
                        i++;
                        continue;
                    }
                    optionS = true;
                }
                case "-f", "-F" -> {
                    if (optionF) {
                        Notificator.printErrorMessage("Option -f is already exists. Skipped");
                        i++;
                        continue;
                    }
                    optionF = true;
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
                ", optionA=" + optionA +
                ", optionS=" + optionS +
                ", optionF=" + optionF +
                ", argumentStorage=" + argumentStorage +
                '}';
    }
}
