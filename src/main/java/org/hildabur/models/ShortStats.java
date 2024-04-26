package org.hildabur.models;

public class ShortStats extends Stats{
    NumericStats integersStats;
    NumericStats floatStats;

    StringStats stringStats;
    public ShortStats() {
        integersStats = new NumericStats();
        floatStats = new NumericStats();
        stringStats = new StringStats();
    }
}
