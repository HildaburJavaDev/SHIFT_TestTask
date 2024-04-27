package org.hildabur.services;

import org.hildabur.enums.TypesOfString;
import org.hildabur.models.*;

public class StatsService {
    public Stats stats;
    private final NumericStats integerStats;
    private final NumericStats floatStats;
    private final StringStats stringStats;
    public StatsService(boolean optionS, boolean optionF) {
        integerStats = new NumericStats();
        floatStats = new NumericStats();
        stringStats = new StringStats();
        if (optionF) stats = new FullStats(integerStats, floatStats, stringStats);
        else if (optionS) stats = new ShortStats(integerStats, floatStats, stringStats);
        else stats = null;
    }

    public TypesOfString updateStats(String str) {
        TypesOfString typeOfString = detectTypeOfString(str);
        switch (typeOfString) {
            case STRING -> stringStats.updateStats(str.length());
            case INTEGER -> integerStats.updateStats(Double.parseDouble(str));
            case FLOAT -> floatStats.updateStats(Double.parseDouble(str));
        }
        return typeOfString;
    }
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

    public String getFinalStats() {
        return stats.getFinalStats();
    }
}
