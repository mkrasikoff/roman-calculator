# Calculator
Реализация калькулятора на языке программирования Java, который умеет работать с целыми и римскими числами. Условия - числа должны быть в диапазоне от 1 до 10.

Схема работы программы следующая:

Основной рабочие классы: Calculator - предназначен для выполнение кода программы, именно в нем находится метод main() и происходит считывание из System.in
                         CalculatorExecutor - предназначен для выполнения арифметических операций над обработанными значениями и возвращения их Calculator
                         CalculatorConvertor - предназначен для обработки полученной из System.in строки, конвертации чисел в int или roman значение и передачи
                                              обработанных строк в CalculatorExecutor.
                                              
Методы в CalculatorConvertor:
                         public String[] convertate(String input) - необходим для работы со всеми методами в классе, возвращает результат для CalculatorExecutor
                         public boolean getIsARoman() - геттер информации о том, являются ли числа roman. Нужен для передачи информации для CalculatorExecutor
                         public String intValueConverter(int num) - необходим для execute() в CalculatorExecutor, для создания String roman из int значения.
                         
                         private boolean isItInteger(String number) - необходим для проверки внутри convertate(), является ли переданное значение int или нет.
                         private int romanToDecimal(String str) - необходим для convertate(), если переданное число roman.
                         private int romanValueConverter(char ch) - необходим для romanToDecimal().
                         
Методы в CalculatorExecutor:
                         public int execute(String inputLine) - необходим для работы с методами из CalculatorConvertor и информации, полученной из них. Цель
                                               метода - получить результат выражения и запомнить в классе String roman значение, если потребуется.
                         public String getRomanValue() - необходим для получения сохраненного в execute() String roman значения, используется в Calculator.
                         
Методы в Calculator:     
                         public static void main(String[] args) - здесь организован ввод-вывод из программы, точка входа в программу.
                         public int calculate(String inputLine) - оболочка для вызова метода execute() из CalculatorExecutor. Возвращает результат в переменную.
                         
                         private String romanResult() - оболочка для получения String roman значения из CalculatorExecutorю
                         
Программа работает исправно, однако ее структура нуждается в доработке. Так, одна из проблем - это путанница с private и public методами. Здесь программе 
необходима доработка, в результате которой доступ к работе программы сможет быть осуществлен только через Calculator и его метод calculate().
                         
                         
