package org.hildabur.models;

import lombok.Getter;

@Getter
public class StringStats extends Stats {
    private long minLength, maxLength;
    public StringStats() {
        super();
        minLength = Long.MAX_VALUE;
        maxLength = Long.MIN_VALUE;
    }

    @Override
    public String getFinalStats() {
        return null;
    }

    public void updateStats(int length) {
        incrementCount();
        updateMinMax(length);
    }

    public void updateMinMax(int length) {
        if (length > maxLength) maxLength = length;
        if (length < minLength) minLength = length;
    }
}
