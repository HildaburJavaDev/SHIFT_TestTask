package org.hildabur.models;

import lombok.Getter;

@Getter
public class ShortStats extends Stats{
    NumericStats integersStats;
    NumericStats floatStats;

    StringStats stringStats;
    public ShortStats(NumericStats integersStats, NumericStats floatStats, StringStats stringStats) {
        this.integersStats = integersStats;
        this.floatStats = floatStats;
        this.stringStats = stringStats;
    }

    @Override
    public String getFinalStats() {
        return "Integers:" + integersStats.getShortStats()
                + "\nFloats: " + floatStats.getShortStats()
                + "\nStrings: " + stringStats.getShortStats();
    }

}
