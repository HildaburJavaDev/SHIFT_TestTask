package org.hildabur.models;

public class ShortStats extends Stats{
    public ShortStats() {
        super();
    }

    public void incrementNumInt() {
        setNumInt(getNumInt() + 1);
    }

    public void incrementNumString() {
        setNumString(getNumString() + 1);
    }

    public void incrementNumFloat() {
        setNumFloat(getNumFloat() + 1);
    }
}
