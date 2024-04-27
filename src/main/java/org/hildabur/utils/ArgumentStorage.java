package org.hildabur.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class ArgumentStorage {
    private boolean optionO;
    private boolean optionA;
    private boolean optionS;
    private boolean optionF;
    private boolean optionP;
    private String prefixFileName;
    private String pathResultFiles;
    private final List<String> sourceFiles;

    public ArgumentStorage() {
        prefixFileName = "";
        pathResultFiles = "";
        sourceFiles = new ArrayList<>();
    }



    public void addSourceFile(String filename) {
        sourceFiles.add(filename);
    }

    @Override
    public String toString() {
        return "FileManager{" +
                ", prefixFileName='" + prefixFileName + '\'' +
                ", pathResultFiles='" + pathResultFiles + '\'' +
                ", sourceFiles=" + Collections.singletonList(sourceFiles) +
                '}';
    }
}
