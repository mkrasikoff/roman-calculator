class CalculatorConvertor {

    public String[] convertate(String input) {
        String[] taskArray = new String[4];
        String[] inputArray = input.split(" ");

        for(int i = 0; i < inputArray.length; i++) {
            taskArray[i] = inputArray[i];
        }
        taskArray[3] = "false";

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
                taskArray[3] = "true";
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

        try {
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
        catch (NumberFormatException | NullPointerException exception) {
            throw new NumberFormatException();
        }

    }
    private int romanValueConverter(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                throw new NumberFormatException();
        }
    }
}