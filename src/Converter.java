class Converter {

    public static int toArabic(String romanNum) {
        RomanNumerals[] arrayRomanNum = RomanNumerals.values();
        int arabicNum = 0;
        for (RomanNumerals romanNumerals : arrayRomanNum) {
            if (romanNumerals.name().equals(romanNum)) {
                arabicNum = romanNumerals.getArabicNum();
            }
        }
        return arabicNum;
    }

    public static String toRoman(int arabicNum) {
        RomanNumerals[] arrayRomanNum = RomanNumerals.values();
        int num = arabicNum;
        String romanNum = "";
        if (num >= 100) {
            for (int i = 0; i < num / 100; i++) {
                romanNum = romanNum.concat("C");
            }
            num = num - ((num / 100) * 100);
        }

        if (num >= 90) {
            romanNum = romanNum.concat("XC");
            num = num - 90;
        }

        if (num >= 50) {
            romanNum = romanNum.concat("L");
            num = num - 50;
        }

        if (num >= 40) {
            romanNum = romanNum.concat("XL");
            num = num - 40;
        }

        if (num >= 10) {
            for (int i = 0; i < num / 10; i++) {
                romanNum = romanNum.concat("X");
            }
            num = num - ((num / 10) * 10);
        }

        if (num > 0) {
            for (RomanNumerals romanNumerals : arrayRomanNum) {
                if (romanNumerals.getArabicNum() == num) {
                    romanNum = romanNum.concat(romanNumerals.name());
                    break;
                }

            }
        }
        return romanNum;
    }
}
