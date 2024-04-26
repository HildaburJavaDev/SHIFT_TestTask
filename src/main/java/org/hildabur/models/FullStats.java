package org.hildabur.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FullStats extends Stats {

    public FullStats() {
    }

//    public String getFinalStats() {
//        getIntegerStats() + "\n\tmin = " + min + "\n\tmax = " + max +
//    }
}
