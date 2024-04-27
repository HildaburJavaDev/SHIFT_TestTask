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
        return "Integers: \n\tcount: " + integersStats.count
                + "\nFloats: \n\tcount: " + floatStats.count
                + "\nStrings: \n\tcount: " + stringStats.count;
    }

}
