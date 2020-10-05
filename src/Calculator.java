import java.util.Scanner;

public class Calculator {
    private final CalculatorExecutor calculatorExecutor = new CalculatorExecutor();

    public int calculate(String inputLine) {
        return calculatorExecutor.execute(inputLine);
    }

    private String romanResult() {
        return calculatorExecutor.getRomanValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Calculator calculator = new Calculator();
        int result = calculator.calculate(inputLine);

        if(result != -1) {
            System.out.println(result);
        }
        else {
            System.out.println(calculator.romanResult());
        }
    }
}

class CalculatorConvertor {
    private boolean isARoman = false;

    public boolean getIsARoman() {
        return isARoman;
    }

    public String[] convertate(String input) {
        String[] taskArray = input.split(" ");

        try {
            int firstNumber, secondNumber;
            String operation;

            if(isItInteger(taskArray[0]) && isItInteger(taskArray[2])) { // is it integer
                firstNumber = Integer.parseInt(taskArray[0]);
                operation = taskArray[1];
                secondNumber = Integer.parseInt(taskArray[2]);
            }
            else { // is it roman
                firstNumber = romanToDecimal(taskArray[0]);
                operation = taskArray[1];
                secondNumber = romanToDecimal(taskArray[2]);
                isARoman = true;
            }

            if(firstNumber > 10 || secondNumber > 10 ||  firstNumber < 1 || secondNumber < 1) {
                throw new NumberFormatException();
            }

            taskArray[0] = Integer.toString(firstNumber);
            taskArray[1] = operation;
            taskArray[2] = Integer.toString(secondNumber);

            return taskArray;
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            throw new NumberFormatException();
        }
    }

    private boolean isItInteger(String number) {
        try {
            int i = Integer.parseInt(number);
            return true;
        }
        catch (NumberFormatException exception) {
            return false;
        }
    }

    private int romanToDecimal(String str) { // Метод сканирует числа попарно, работает только с корректными цифрами
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = romanValueConverter(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = romanValueConverter(str.charAt(i + 1));

                if (s1 >= s2) {
                    result += s1;
                }
                else {
                    result += s2 - s1; // пример: IV или IX
                    i++; // так как посчитали уже 2 цифры
                }
            }
            else {
                result += s1;
            }
        }
        return result;
    }

    private int romanValueConverter(char ch) {
        if (ch == 'I')
            return 1;
        else if (ch == 'V')
            return 5;
        else if (ch == 'X')
            return 10;
        else throw new NumberFormatException();
    }

    public String intValueConverter(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100 }; // так как X * X = 100 - максимальный результат
        int times = 0;

        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];

            while (times > 0) {
                stringBuilder.append(romans[i]);
                times--;
            }
        }
        return stringBuilder.toString();
    }
}

class CalculatorExecutor {
    private final CalculatorConvertor calculatorConvertor = new CalculatorConvertor();
    private boolean isARoman = false;
    private String romanValue = "";

    public boolean isARoman() {
        return isARoman;
    }

    public String getRomanValue() {
        return romanValue;
    }

    public int execute(String inputLine) {
        try {
            String[] fromConvertor = calculatorConvertor.convertate(inputLine);

            int firstNumber = Integer.parseInt(fromConvertor[0]);
            String operation = fromConvertor[1];
            int secondNumber = Integer.parseInt(fromConvertor[2]);
            isARoman = calculatorConvertor.getIsARoman();
            int result;

            if(operation.equals("*")) result = firstNumber * secondNumber;
            else if(operation.equals("/")) result = firstNumber / secondNumber;
            else if(operation.equals("+")) result = firstNumber + secondNumber;
            else if(operation.equals("-")) result = firstNumber - secondNumber;
            else throw new NumberFormatException();

            if(!isARoman) {
                return result;
            }
            else {
                romanValue = calculatorConvertor.intValueConverter(result);
                return -1;
            }
        }
        catch (NumberFormatException exception) {
            throw new NumberFormatException("Wrong input format. Try again with another numbers.");
        }
    }
}