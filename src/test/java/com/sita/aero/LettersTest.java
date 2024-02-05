package com.sita.aero;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LettersTest {
    String zeros = StringUtils.repeat("0", 6);
    char[] resultArray = zeros.toCharArray();
    LicensePlates sut = new LicensePlates();

    @Test
    public void getNoLetterPlate_case1() {
        int n = 100000;
        int remainder = sut.setLetters(n, 0, resultArray);

        assertEquals("000000",  String.valueOf(resultArray));
        assertEquals(n,  remainder);
    }

    @Test
    public void getNoLetterPlate_case2() {
        int n = 900000;

        int remainder = sut.setLetters(n, 0, resultArray);

        assertEquals("000000", String.valueOf(resultArray));
        assertEquals(n,  remainder);
    }

    @Test
    public void getCharactersPlate_with1digit() {
        int n = 3599999;

        int remainder = sut.setLetters( n, 1, resultArray);

        assertEquals("00000Z", String.valueOf(resultArray));
        assertEquals(99999,  remainder);
    }

    @Test
    public void getCharactersPlate_with1digits_2Letters_case1() {
        int n = 3610010;

        int remainder = sut.setLetters( n, 2, resultArray);

        assertEquals("0000AB", String.valueOf(resultArray));
        assertEquals(10,  remainder);
    }

    @Test
    public void getCharactersPlate_with1digits_2Letters_case2() {
        int n = 3859999;

        int remainder = sut.setLetters( n, 2, resultArray);

        assertEquals("0000AZ", String.valueOf(resultArray));
        assertEquals(9999,  remainder);
    }

    @Test
    public void getCharactersPlate_with1digits_2Letters_case3() {
        int n = 3870001;

        int remainder = sut.setLetters( n, 2, resultArray);

        assertEquals("0000BB", String.valueOf(resultArray));
        assertEquals(1,  remainder);
    }

    @Test
    public void getCharactersPlate_with0digits_3Letters_case1() {
        int n = 10361000;

        int remainder = sut.setLetters( n, 3, resultArray);

        assertEquals("000AAB", String.valueOf(resultArray));
        assertEquals(0,  remainder);
    }

    @Test
    public void getCharactersPlate_with0digits_6Letters_case1() {
        int n = 501363135;

        int remainder = sut.setLetters(n, 6, resultArray);

        assertEquals("ZZZZZZ", String.valueOf(resultArray));
        assertEquals(0,  remainder);
    }
}
