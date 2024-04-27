package org.hildabur.services;

import org.hildabur.middleware.FilesExistenceCheckerMiddleware;
import org.hildabur.utils.ArgumentStorage;
import org.hildabur.utils.Notificator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.util.List;
import java.util.Scanner;

public class FileService {
    ArgumentStorage argumentStorage;

    public FileService(ArgumentStorage argumentStorage) {
        this.argumentStorage = argumentStorage;
    }

    public void createOutputFiles() {
        if (!FilesExistenceCheckerMiddleware.checkDirectory(argumentStorage.getPathResultFiles())) System.out.println("Не существует");
//        String currentDirectory = System.getProperty("user.dir");
//        System.out.println("Текущая директория: " + currentDirectory + "\n Ожидаемая " + currentDirectory + argumentStorage.getPathResultFiles());
    }

    public void calcStats(boolean optionS, boolean optionF, File file) {
        StatsService statsService = new StatsService(optionS, optionF);
        readFile(statsService, file);
//        try {
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }

    public void readFile(StatsService statsService, File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                statsService.updateStats(str);
            }
            System.out.println(statsService.getFinalStats());
        } catch (FileNotFoundException e) {
        }
    }

    public void openFiles(boolean optionS, boolean optionF) {
        List<String> files = argumentStorage.getSourceFiles();
        for (String filename : files) {
            try{
//                System.out.println(filename);
                File file = new File(filename);
                calcStats(optionS, optionF, file);
            } catch (NullPointerException exception) {
                Notificator.printErrorMessage("Нет файлов");
                return;
            } catch (SecurityException exception) {
                Notificator.printErrorMessage("Нет прав для доступа к файлу");
            } catch (InvalidPathException exception) {
                Notificator.printErrorMessage("Неправильный путь к файлу");
            }
        }
    }
}
