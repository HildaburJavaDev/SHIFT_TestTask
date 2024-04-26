package org.hildabur.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FullStats extends Stats {
    private long min, max, sum, avg, minLength, maxLength;

    public FullStats() {
        super();
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        sum = 0;
        avg = 0;
        minLength = Long.MAX_VALUE;
        maxLength = Long.MIN_VALUE;
    }
}
