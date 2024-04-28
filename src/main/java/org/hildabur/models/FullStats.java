package org.hildabur.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// ведение полной статистики
@EqualsAndHashCode(callSuper = true)
@Getter
public class FullStats extends Stats {
// модели данных для статистики
    private final NumericStats integersStats;
    private final NumericStats floatStats;

    private final StringStats stringStats;
    public FullStats(NumericStats integersStats, NumericStats floatStats, StringStats stringStats) {
        this.integersStats = integersStats;
        this.floatStats = floatStats;
        this.stringStats = stringStats;
    }

    @Override
    public String getFinalStats() {
        return "Integers: " + integersStats.getFullStats()
                + "\nFloats: " + floatStats.getFullStats()
                + "\nStrings: " + stringStats.getFullStats();
    }
}
