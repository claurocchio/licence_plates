package com.sita.aero;

public class Util {

    protected static int DIGITS = 6;

    protected static int getLevel(int n) {
        int lastIdxForLevel = getBasePlateForLevel(0);

        for (int level = 0; level <= DIGITS; level++) {
            if (n < lastIdxForLevel) {
                return level;
            }
            lastIdxForLevel = getBasePlateForLevel(level + 1);
        }
        throw new RuntimeException("Index is out of bounds for the number of digits");
    }

    static int getBasePlateForLevel(int level) {
        int basePlate = 0;
        for (int idx = level; idx >= 0; idx--) {
            basePlate += getMaxNumberPerLevel(idx);
        }
        return basePlate;
    }

    protected static int getMaxNumberPerLevel(int idx) {
        return (int) Math.pow(10, DIGITS - idx) * (int) Math.pow(26, idx);
    }

    public static char getChar(int i) {
        return i < 0 || i > 25 ? '?' : (char) ('A' + i);
    }
}
