package org.hildabur.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class FullStats extends Stats {

    NumericStats integersStats;
    NumericStats floatStats;

    StringStats stringStats;
    public FullStats(NumericStats integersStats, NumericStats floatStats, StringStats stringStats) {
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
