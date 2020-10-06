class CalculatorExecutor {
    private final CalculatorConvertor calculatorConvertor = new CalculatorConvertor();

    public String execute(String inputLine) {
        try {
            String[] fromConvertor = calculatorConvertor.convertate(inputLine);

            int firstNumber = Integer.parseInt(fromConvertor[0]);
            String operation = fromConvertor[1];
            int secondNumber = Integer.parseInt(fromConvertor[2]);
            int result;

            switch (operation) {
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                default:
                    throw new NumberFormatException();
            }

            if(!Boolean.parseBoolean(fromConvertor[3])) { // if integer return normal result
                return Integer.toString(result);
            }
            else { // if roman return converted result
                return intValueConverter(result);
            }
        }
        catch (NumberFormatException exception) {
            throw new NumberFormatException("Wrong input format. Try again with another numbers.");
        }
    }

    private String intValueConverter(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100 }; // так как X * X = 100 - максимальный результат
        int times = 0;

        if(num == 0) {
            stringBuilder.append(0);
            return stringBuilder.toString();
        }

        if(num < 0) {
            stringBuilder.append("-");
            num = -num;
        }

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
