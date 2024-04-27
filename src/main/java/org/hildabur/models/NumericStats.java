package org.hildabur.models;

import lombok.Getter;

@Getter
public class NumericStats extends Stats {

    protected double min, max, sum, avg;

    public NumericStats() {
        super();
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        sum = 0;
        avg = 0;
    }

    @Override
    public String getFinalStats() {
        return null;
    }

    public void updateStats(double num) {
        incrementCount();
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

    public String getShortStats() {
        return "\n\tcount: " + count;
    }

    public String getFullStats() {
        calcAvg();
        return """
                \n\tcount:\s""" + count +
                """
                        \n\tmin:\s""" + ((min == (long) min) ? String.valueOf((long) min) : String.valueOf(min)) +
                """
                        \n\tmax:\s""" + ((max == (long) max) ? String.valueOf((long) max) : String.valueOf(max)) +
                """
                        \n\tsum:\s""" + ((sum == (long) sum) ? String.valueOf((long) sum) : String.valueOf(sum)) +
                """
                        \n\tavg:\s""" + ((avg == (long) avg) ? String.valueOf((long) avg) : String.valueOf(avg));

    }
}
