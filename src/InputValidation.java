class InputValidation {

    public static boolean isInputCorrect(String input) {
        if (!isMathOperation(input)) {
            throw new InputIncorrectException("строка не является математической операцией");
        } else if (!isOneMathOperation(input)) {
            throw new InputIncorrectException("формат математической операции не удовлетворяет заданию");
        } else if (!isCorrectNumSystem(input)) {
            throw new InputIncorrectException("некорректный ввод");
        } else if (isArabianExp(input)) {
            String[] operands = arrayOperands(input);
            for (String operand : operands) {
                if (Integer.parseInt(operand) < 1 | Integer.parseInt(operand) > 10) {
                    throw new InputIncorrectException(" числа от 1 до 10 включительно, не более");
                }
            }
        }
        return true;
    }

    public static boolean isMathOperation(String input) {
        return input.contains("+") || input.contains("-") || input.contains("/") || input.contains("*");
    }

    public static String[] arrayOperands(String input) {
        return input.split(mathOperator(input));
    }

    public static boolean isOneMathOperation(String input) {
        String[] operands = arrayOperands(input);
        return !(operands.length > 2 | isMathOperation(operands[0]) | isMathOperation(operands[1]));
    }

    public static String mathOperator(String input) {
        String result = "";
        if (input.contains("+")) {
            result = "\\+";
        } else if (input.contains("-")) {
            result = "-";
        } else if (input.contains("/")) {
            result = "/";
        } else if (input.contains("*")) {
            result = "\\*";
        }
        return result;

    }

    public static boolean isRomanExp(String input) {
        String[] operands = arrayOperands(input);
        boolean result = false;
        RomanNumerals[] romanNumerals = RomanNumerals.values();
        for (RomanNumerals romanNumeral : romanNumerals) {
            for (String operand : operands) {
                if (romanNumeral.name().equals(operand)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isArabianExp(String input) {
        String[] operands = arrayOperands(input);
        boolean result = true;
        for (String operand : operands) {
            for (int i = 0; i < operand.length(); i++) {
                if (!Character.isDigit(operand.charAt(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isCorrectNumSystem(String input) {
        return isArabianExp(input) != isRomanExp(input);
    }
}
