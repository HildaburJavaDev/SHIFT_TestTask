package org.hildabur.services;

import org.hildabur.enums.TypesOfString;
import org.hildabur.middleware.FilesExistenceCheckerMiddleware;
import org.hildabur.models.FileProvider;
import org.hildabur.utils.ArgumentStorage;
import org.hildabur.utils.Notificator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;
import java.util.Scanner;

// сервис, управляющий всей логикой работы с файлами
public class FileService {
    ArgumentStorage argumentStorage;

    public FileService(ArgumentStorage argumentStorage) {
        this.argumentStorage = argumentStorage;
    }

    public void createOutputFiles() {
        if (!FilesExistenceCheckerMiddleware.checkDirectory(argumentStorage.getPathResultFiles()))
            Notificator.printErrorMessage("Не существует");
    }

    private void calcStats(File file, StatsService statsService, FileProvider fileProvider) {
        readFile(statsService, file, fileProvider);
    }

    private void readFile(StatsService statsService, File file, FileProvider fileProvider) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
//                определяем, какой тип данных был только что считан из файла
                TypesOfString typeOfString = statsService.updateStats(str);
//                проверяем необходимость создания файла (если тип данных встречается впервые)
                if (isNeedleToCreateFile(typeOfString, statsService)) {
                    fileProvider.createFile(typeOfString);
                    fileProvider.writeToFile(typeOfString, argumentStorage.isOptionA(), str);
                    continue;
                }
//                 записываем в файл. True - потому что не нужно перезаписывать файл
                fileProvider.writeToFile(typeOfString, true, str);
            }
        } catch (FileNotFoundException e) {
            Notificator.printErrorMessage(String.format("Файл \"%s\" не найден - пропускаем%n", file.getName()));
        } catch (IOException e) {
            Notificator.printErrorMessage("Ошибка записи в файл");
        }
    }

//    проверка необходимости создания файла
    private boolean isNeedleToCreateFile(TypesOfString typeOfString, StatsService statsService) {
        if ((typeOfString.equals(TypesOfString.INTEGER) && (statsService.integerStats.getCount() == 1))) {
            return true;
        } else if ((typeOfString.equals(TypesOfString.FLOAT)) && (statsService.floatStats.getCount() == 1)) {
            return true;
        } else return (typeOfString.equals(TypesOfString.STRING)) && (statsService.stringStats.getCount() == 1);
    }

//    открываем каждый файл по очереди из списка файлов хранящихся в argumentStorage
    public void openFiles() {
        StatsService statsService = new StatsService(argumentStorage.isOptionS(), argumentStorage.isOptionF());
        FileProvider fileProvider = new FileProvider(argumentStorage.getPathResultFiles(), argumentStorage.getPrefixFileName());
        List<String> files = argumentStorage.getSourceFiles();
        for (String filename : files) {
            try{
                File file = new File(filename);
                calcStats(file, statsService, fileProvider);
            } catch (NullPointerException exception) {
                Notificator.printErrorMessage("Нет файлов");
                return;
            } catch (SecurityException exception) {
                Notificator.printErrorMessage("Нет прав для доступа к файлу");
            } catch (InvalidPathException exception) {
                Notificator.printErrorMessage("Неправильный путь к файлу");
            }
        }
        System.out.println(statsService.getFinalStats());
    }
}
