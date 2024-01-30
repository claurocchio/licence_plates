import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void getNoLetterPlate_case1() {
        int n = 100000;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("100000", nthPlate);
    }

    @Test
    public void getNoLetterPlate_case2() {
        int n = 900000;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("900000", nthPlate);
    }

    @Test
    public void getFirstLetterPlate_case1() {
        int n = 1000001;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("00001A", nthPlate);
    }

    @Test
    public void getFirstLetterPlate_case2() {
        int n = 1100001;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("00001B", nthPlate);
    }

    @Test
    public void getFirstLetterPlate_case3() {
        int n = 3100045;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("00045V", nthPlate);
    }

    @Test
    public void getFirstLetterPlate_case4() {
        int n = 3599999;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("99999Z", nthPlate);
    }

    @Test
    public void getTwoLetterPlate_case1() {
        int n = 3600001;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("0001AA", nthPlate);
    }

    @Test
    public void getTwoLetterPlate_case2() {
        int n = 3610001;
        String nthPlate = Main.getNthPlate(n);
        assertEquals("0001AB", nthPlate);
    }
}