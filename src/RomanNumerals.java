enum RomanNumerals {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    final int arabicNum;

    RomanNumerals(int arabicNum) {
        this.arabicNum = arabicNum;
    }

    public int getArabicNum() {
        return arabicNum;
    }
}
