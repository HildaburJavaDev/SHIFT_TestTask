package org.hildabur.middleware;

import java.io.File;

public class DirectoryExistenceCheckerMiddleware {
    public static boolean check(String directoryPath) {
        File directory = new File(directoryPath);
        return (directory.exists() && directory.isDirectory());
    }
}
