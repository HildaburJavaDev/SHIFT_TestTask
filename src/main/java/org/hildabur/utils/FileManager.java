package org.hildabur.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
    private final String stringFileNameDefault;
    private final String integerFileNameDefault;
    private final String floatFileNameDefault;
    private String prefixFileName;
    private String pathResultFiles;
    private final List<String> sourceFiles;

    public FileManager() {
        stringFileNameDefault = "strings.txt";
        integerFileNameDefault = "integer.txt";
        floatFileNameDefault = "floats.txt";
        prefixFileName = "";
        pathResultFiles = "";
        sourceFiles = new ArrayList<>();
    }


    public void setPrefixFileName(String prefixFileName) {
        this.prefixFileName = prefixFileName;
    }

    public void setPathResultFiles(String pathResultFiles) {
        this.pathResultFiles = pathResultFiles;
    }

    public void addSourceFile(String filename) {
        sourceFiles.add(filename);
    }

    @Override
    public String toString() {
        return "FileManager{" +
                "stringFileNameDefault='" + stringFileNameDefault + '\'' +
                ", integerFileNameDefault='" + integerFileNameDefault + '\'' +
                ", floatFileNameDefault='" + floatFileNameDefault + '\'' +
                ", prefixFileName='" + prefixFileName + '\'' +
                ", pathResultFiles='" + pathResultFiles + '\'' +
                ", sourceFiles=" + Collections.singletonList(sourceFiles) +
                '}';
    }
}
