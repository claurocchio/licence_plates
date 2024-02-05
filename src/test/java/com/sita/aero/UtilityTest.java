package com.sita.aero;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilityTest {

    @Test
    public void getLevel_0() {
        int n = 999999;

        int level = Util.getLevel(n);
        assertEquals(0, level);
    }

    @Test
    public void getLevel_1() {
        int n = 3599998;

        int level = Util.getLevel(n);
        assertEquals(1, level);
    }

    @Test
    public void getLevel_2() {
        int n = 3600015;

        int level = Util.getLevel(n);
        assertEquals(2, level);
    }

    @Test
    public void getLevel_3() {
        int n = 10360024;

        int level = Util.getLevel(n);
        assertEquals(3, level);
    }

    @Test
    public void getLevel_3Limit() {
        int n = 27935999;

        int level = Util.getLevel(n);
        assertEquals(3, level);
    }

    @Test
    public void getLevel_4() {
        int n = 27936000;

        int level = Util.getLevel(n);
        assertEquals(4, level);
    }

    @Test
    public void getLevel_5_start() {
        int n = 73633600;

        int level = Util.getLevel(n);
        assertEquals(5, level);
    }

    @Test
    public void getLevel_5_limit() {
        int n = 192447359;

        int level = Util.getLevel(n);
        assertEquals(5, level);
    }

    @Test
    public void getLevel_6_start() {
        int n = 192447360;

        int level = Util.getLevel(n);
        assertEquals(6, level);
    }

    @Test
    public void getLevel_6_limit() {
        int n = 501363135;

        int level = Util.getLevel(n);
        assertEquals(6, level);
    }

    @Test(expected = RuntimeException.class)
    public void getLimitException() {
        int n = 501363136;

        int level = Util.getLevel(n);
        assertEquals(0, level);
    }
}
