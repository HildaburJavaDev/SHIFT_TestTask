package org.hildabur.models;

import lombok.Data;

// виртуальный класс статистики, для последующего расширения классами полной и короткой статистики
@Data
public abstract class Stats {
    protected long count;

    public Stats() {
        count = 0;
    }

    public void incrementCount() {
        count++;
    }

    public abstract String getFinalStats();

}
