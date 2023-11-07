import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("введите матаматическое выражение");
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        while (input.isEmpty()) {
            System.out.println("введите матаматическое выражение");
            input = scn.nextLine();
        }
        input = input.replaceAll(" ", "").toUpperCase();
        while (InputValidation.isInputCorrect(input)) {
            System.out.println(calc(input));
            input = scn.nextLine();
            input = input.replaceAll(" ", "").toUpperCase();
        }
    }

    public static String calc(String input) {
        return Calculation.resultExp(input);
    }
}