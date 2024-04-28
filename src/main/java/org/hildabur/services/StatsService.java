package org.hildabur.services;

import org.hildabur.enums.TypesOfString;
import org.hildabur.models.*;

// сервис, управляющий логикой ведения статистики
public class StatsService {
    public Stats stats;
    protected final NumericStats integerStats;
    protected final NumericStats floatStats;
    protected final StringStats stringStats;
    public StatsService(boolean optionS, boolean optionF) {
        integerStats = new NumericStats();
        floatStats = new NumericStats();
        stringStats = new StringStats();
//        определяем экземпляром какого класса должен быть объект stats - полной статистики или короткой
        if (optionF) stats = new FullStats(integerStats, floatStats, stringStats);
        else if (optionS) stats = new ShortStats(integerStats, floatStats, stringStats);
        else stats = null;
    }

//    обновляем статистику для соответствующего типа данных
    public TypesOfString updateStats(String str) {
        TypesOfString typeOfString = detectTypeOfString(str);
        switch (typeOfString) {
            case STRING -> stringStats.updateStats(str.length());
            case INTEGER -> integerStats.updateStats(Double.parseDouble(str));
            case FLOAT -> floatStats.updateStats(Double.parseDouble(str));
        }
        return typeOfString;
    }
//     определяем тип данных в строке, считанной из файла
    private TypesOfString detectTypeOfString(String str) {
        if (isInteger(str)) return TypesOfString.INTEGER;
        else if (isFloat(str)) return TypesOfString.FLOAT;
        else if (str.length() != 0) return TypesOfString.STRING;
        return TypesOfString.EMPTY_STRING;
    }

    private boolean isInteger(String str) {
        try{
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isFloat(String str) {
        try{
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

//     метод для получения финальной статистики
    public String getFinalStats() {
        return stats.getFinalStats();
    }
}
