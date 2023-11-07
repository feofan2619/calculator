class Calculation {
    public static String resultExp(String exp) {
        String result = "";
        int a;
        int b;
        int c;

        if (InputValidation.isArabianExp(exp)) {
            a = Integer.parseInt(InputValidation.arrayOperands(exp)[0]);
            b = Integer.parseInt(InputValidation.arrayOperands(exp)[1]);
            c = calcExp(a, b, InputValidation.mathOperator(exp));
            result = c + "";
        } else if (InputValidation.isRomanExp(exp)) {
            a = Converter.toArabic(InputValidation.arrayOperands(exp)[0]);
            b = Converter.toArabic(InputValidation.arrayOperands(exp)[1]);
            c = calcExp(a, b, InputValidation.mathOperator(exp));
            if (c < 0) {
                throw new RuntimeException("в римской системе нет отрицательных чисел");
            }
            result = Converter.toRoman(c);
        }
        return result;
    }

    public static int calcExp(int a, int b, String operator) {
        return switch (operator) {
            case "-" -> a - b;
            case "\\+" -> a + b;
            case "\\*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}
