package org.hildabur.middleware;

import java.io.File;

public class FilesExistenceCheckerMiddleware {
    public static boolean checkDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        return (directory.exists() && directory.isDirectory());
    }
}
