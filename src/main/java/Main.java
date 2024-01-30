

public class Main {
    public static void main(String[] args) {
        System.out.println(getNthPlate(Integer.parseInt(args[0])));
    }


    public static String getNthPlate(int n) {
        int places = 6;

        StringBuilder lastPart = new StringBuilder();
        int rest = calculatePlate(places, n, lastPart);

        return fillWithZeros(rest, lastPart.toString());
    }

    public static int calculatePlate(int places, int n, StringBuilder lastPart) {
        int lastPlate = (int) Math.pow(10, places);
        int div = n / lastPlate;

        if (div == 0) {
            return n;
        }

        int lastDigit = 0;
        int rest = n - lastPlate;

        lastPlate = (int) Math.pow(10, places - 1);
        int div2 = rest / lastPlate;
        int rest2 = rest % lastPlate;

        if (div2 / 26 > 0) {
            lastDigit = div2 % 26;
            lastPart.append(getChar(lastDigit));
            rest2 = calculatePlate(places - 2, rest2, lastPart);
        }

        lastDigit = div2 % 26;
        lastPart.append(getChar(lastDigit));

        return rest2;
    }

    private static String fillWithZeros(int rest, String suffix) {
        String number = Integer.toString(rest);
        int currentLength = number.length() + suffix.length();

        StringBuilder zeros = new StringBuilder();
        for (; currentLength < 6; currentLength++) {
            zeros.append("0");
        }
        return zeros + number + suffix;
    }

    public static char getChar(int i) {
        return i < 0 || i > 25 ? '?' : (char) ('A' + i);
    }

//    public String getLastPart() {
//        for(; rest >= lastPlate; idx++) {
//        rest = n % lastPlate;
//        places--;
//        lastPlate = (int)Math.pow(10, places);
//    }
}
