package org.hildabur.models;

public class StringStats extends Stats {
    private long minLength, maxLength;
    public StringStats() {
        super();
        minLength = Long.MAX_VALUE;
        maxLength = Long.MIN_VALUE;
    }

    public void updateStats(int length) {
        count++;
        updateMinMax(length);
    }

    public void updateMinMax(int length) {
        if (length > maxLength) maxLength = length;
        if (length < minLength) minLength = length;
    }
}
