package org.hildabur.models;

public class NumericStats extends Stats {

    protected double min, max, sum, avg;
    public NumericStats() {
        super();
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        sum = 0;
        avg = 0;
    }

    public void updateStats(double num) {
        incrementNumInt();
        updateMinMax(num);
        calcSum(num);
    }
    public void updateMinMax(double num) {
        if (num > max) max = num;
        if (num < min) min = num;
    }

    public void calcSum(double num) {
        sum += num;
    }

    public void calcAvg() {
        avg = sum / count;
    }
}
