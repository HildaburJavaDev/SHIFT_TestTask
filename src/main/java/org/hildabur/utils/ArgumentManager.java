package org.hildabur.utils;

import lombok.Getter;

@Getter
public class ArgumentManager {
    private ArgumentStorage argumentStorage;

    public ArgumentManager() {}

    public void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a", "-A" -> argumentStorage.setOptionA(true);
                case "-o", "-O" -> {
                    if(argumentStorage.isOptionO()) {
                        Notificator.printErrorMessage("Option -o is already exists. Skipped");
                        i++;
                        continue;
                    }

                    argumentStorage.setOptionO(true);
                    argumentStorage.setPathResultFiles(args[++i]);
                }
                case "-p", "-P" -> {
                    if(argumentStorage.isOptionP()) {
                        Notificator.printErrorMessage("Option -p is already exists. Skipped");
                        i++;
                        continue;
                    }

                    argumentStorage.setOptionP(true);
                    argumentStorage.setPrefixFileName(args[++i]);
                }
                case "-s", "-S" -> {
                    if (argumentStorage.isOptionS()) {
                        Notificator.printErrorMessage("Option -s is already exists. Skipped");
                        i++;
                        continue;
                    }
                    argumentStorage.setOptionS(true);
                }
                case "-f", "-F" -> {
                    if (argumentStorage.isOptionF()) {
                        Notificator.printErrorMessage("Option -f is already exists. Skipped");
                        i++;
                        continue;
                    }
                    argumentStorage.setOptionF(true);
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
                ", argumentStorage=" + argumentStorage +
                '}';
    }
}
