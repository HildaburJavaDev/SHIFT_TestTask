package org.hildabur.middleware;

import java.io.File;

// middleware для проверки существования директорий

public class FilesExistenceCheckerMiddleware {
    public static boolean checkDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        return (directory.exists() && directory.isDirectory());
    }
}
