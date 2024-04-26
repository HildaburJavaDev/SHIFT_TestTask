package org.hildabur.utils;

import lombok.Getter;

@Getter
public class ArgumentManager {
    private boolean optionO;
    private boolean optionP;
    private boolean optionA;
    private FileManager fileManager;

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
                    fileManager.setPathResultFiles(args[++i]);
                }
                case "-p", "-P" -> {
                    if(optionP) {
                        Notificator.printErrorMessage("Option -p is already exists. Skipped");
                        i++;
                        continue;
                    }

                    optionP = true;
                    fileManager.setPrefixFileName(args[++i]);
                }
                default -> fileManager.addSourceFile(args[i]);
            }
        }
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public String toString() {
        return "ArgumentManager{" +
                "optionO=" + optionO +
                ", optionP=" + optionP +
                ", optionA=" + optionA + '\''+  fileManager.toString() +
                '}';
    }
}
