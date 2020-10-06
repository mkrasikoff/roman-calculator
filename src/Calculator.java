import java.util.Scanner;

public class Calculator {
    private final CalculatorExecutor calculatorExecutor = new CalculatorExecutor();

    public String calculate(String inputLine) {
        return calculatorExecutor.execute(inputLine);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String inputLine = scanner.nextLine();
        System.out.println(calculator.calculate(inputLine));
    }
}

