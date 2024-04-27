package org.hildabur.models;

import lombok.Data;

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
