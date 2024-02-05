package com.sita.aero;

import org.apache.commons.lang3.StringUtils;

public class LicensePlates {
    private final int DIGITS = 6;
    private final String zeros = StringUtils.repeat("0", DIGITS);
    private final char[] resultArray = zeros.toCharArray();

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Invalid arguments");
            return;
        }
        LicensePlates licensePlates = new LicensePlates();
        System.out.println(licensePlates.calculatePlate(Integer.parseInt(args[0])));
    }

    /**
     * Calculates the License plate based on the nth element index
     * @param n the received n index
     * @return the license plate string
     */
    public String calculatePlate(int n) {
        int level = Util.getLevel(n);

        int numericRemainder = setLetters(n, level, resultArray);

        setNumbers(numericRemainder,DIGITS - level);

        return String.valueOf(resultArray);
    }

    private void setNumbers(int numericRemainder, int position) {
        char[] nArray = ("" + numericRemainder).toCharArray();

        if (position - nArray.length >= 0) {
            System.arraycopy(nArray, 0, resultArray, position - nArray.length, nArray.length);
        }
    }

    /**
     * Store the corresponding calculated letters in the resultArray and return the remainder digits
     * @param n the received n index
     * @param level the corresponding level
     * @param resultArray the array where the result is stored
     * @return Remainder
     */
    public int setLetters(int n, int level, char[] resultArray) {
        int firstAlphanumericPlateIdx = Util.getBasePlateForLevel(level - 1);
        int firstRemainder = n - firstAlphanumericPlateIdx;
        int remainder = n;

        for (int letterIdx = level; letterIdx > 0; letterIdx--) {
            int position = DIGITS - letterIdx;
            remainder = calculateLetterForPosition(position, level, firstRemainder, resultArray);
        }

        return remainder;
    }

    private int calculateLetterForPosition(int pos, int level, int n, char[] resultArray) {
        int numericDigits = DIGITS - level;
        int alphaDigits = DIGITS - pos - 1;

        int sectionSize = (int) Math.pow(10, numericDigits) * (int) Math.pow(26, alphaDigits);

        int division = n / sectionSize;

        resultArray[pos] = Util.getChar(division % 26);

        return n - division * sectionSize;
    }
}
