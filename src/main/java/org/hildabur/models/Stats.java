package org.hildabur.models;

import lombok.Data;

@Data
public abstract class Stats {
    private long numInt, numString, numFloat;

    public Stats() {
        numInt = 0;
        numString = 0;
        numFloat = 0;
    }
}
