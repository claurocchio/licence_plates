package com.sita.aero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MainTest {
    LicensePlates sut = new LicensePlates();

    @Test
    public void getLevel0Plate_case1() {
        int n = 100000;
        String nthPlate = sut.calculatePlate(n);
        assertEquals("100000", nthPlate);
    }

    @Test
    public void getLevel0Plate_case2() {
        int n = 900000;
        String nthPlate = sut.calculatePlate(n);

        assertEquals("900000", nthPlate);
    }

    @Test
    public void getFirstLevelPlate_case1() {
        int n = 1000001;
        String nthPlate = sut.calculatePlate(n);

        assertEquals("00001A", nthPlate);
    }

    @Test
    public void getFirstLevelPlate_case2() {
        int n = 1100001;
        String nthPlate = sut.calculatePlate(n);

        assertEquals("00001B", nthPlate);
    }

    @Test
    public void getFirstLevelPlate_case3() {
        int n = 3100045;
        String nthPlate = sut.calculatePlate(n);

        assertEquals("00045V", nthPlate);
    }

    @Test
    public void getFirstLetterPlate_case4() {
        int n = 3599999;
        String nthPlate = sut.calculatePlate(n);

        assertEquals("99999Z", nthPlate);
    }

    @Test
    public void getTwoLetterPlate_case1() {
        int n = 3621001;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("1001AC", nthPlate);
    }

    @Test
    public void getTwoLetterPlate_case2() {
        int n = 3610001;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("0001AB", nthPlate);
    }

    @Test
    public void getThreeLetterPlate_case1() {
        int n = 10360099;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("099AAA", nthPlate);
    }

    @Test
    public void getThreeLetterPlate_case2() {
        int n = 10386995;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("995ABA", nthPlate);
    }

    @Test
    public void getPlateLevel_5_case1() {
        int n = 192447340;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("0ZZZZY", nthPlate);
    }

    @Test
    public void getPlateLevel_5_limit() {
        int n = 192447359;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("9ZZZZZ", nthPlate);
    }

    @Test
    public void getPlate_with0digits_6Letters_case1() {
        int n = 501363135;

        String nthPlate = sut.calculatePlate(n);

        assertEquals("ZZZZZZ", nthPlate);
    }
}