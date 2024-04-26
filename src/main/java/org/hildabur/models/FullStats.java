package org.hildabur.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FullStats extends Stats {
    private long min, max, sum, avg, minLength, maxLength;

    public FullStats() {
        super();
        min = 0;
        max = 0;
        sum = 0;
        avg = 0;
        minLength = 0;
        maxLength = 0;
    }
}
