package org.hildabur.models;

import lombok.Getter;

// модель для всех числовых типов (целых и вещественных)
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
//        если значения у нас отсутствует данный тип данных в файле, то статистика для него не определена
        String minString = (min == Long.MAX_VALUE) ? "Undefined" : ((min == (long) min) ? String.valueOf((long) min) : String.valueOf(min));
        String maxString = (max == Long.MIN_VALUE) ? "Undefined" : ((max == (long) max) ? String.valueOf((long) max) : String.valueOf(max));
        String sumString = (count == 0) ? "Undefined" : ((sum == (long) sum) ? String.valueOf((long) sum) : String.valueOf(sum));
        String avgString = (Double.isNaN(avg)) ? "Undefined" : ((avg == (long) avg) ? String.valueOf((long) avg) : String.valueOf(avg));
        return """
            \n\tcount:\s""" + count +
                """
                        \n\tmin:\s""" + minString +
                """
                        \n\tmax:\s""" + maxString +
                """
                        \n\tsum:\s""" + sumString +
                """
                        \n\tavg:\s""" + avgString;
    }
}
