package com.example.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculation {
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String number = "";
    private String number0;
    private String number1;
    private String number2;
    private String number3;
    private String number4;
    private String number5;
    private String number6;
    private String number7;
    private String number8;
    private String number9;
    private String symbolPoi;
    final private char symbolPlus = '+';
    final private char symbolMin = '-';
    final private char symbolMul = '*';
    final private char symbolDiv = '=';
    private char usingSymbol;
    private boolean isSymbol = false;
    private double resultNumber = 0;
    private String error0 = "ERROR: деление на ноль";
    private int countPoint = 0;

    public Calculation() {
        number0 = "0";
        number1 = "1";
        number2 = "2";
        number3 = "3";
        number4 = "4";
        number5 = "5";
        number6 = "6";
        number7 = "7";
        number8 = "8";
        number9 = "9";
        symbolPoi = ".";
    }

    public int getCountPoint() {
        return countPoint;
    }

    public String getNumber() {
        return number;
    }

    public String getNumber0() {
        return number0;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }

    public String getNumber3() {
        return number3;
    }

    public String getNumber4() {
        return number4;
    }

    public String getNumber5() {
        return number5;
    }

    public String getNumber6() {
        return number6;
    }

    public String getNumber7() {
        return number7;
    }

    public String getNumber8() {
        return number8;
    }

    public String getNumber9() {
        return number9;
    }

    public String getSymbolPoi() {
        return symbolPoi;
    }

    public char getSymbolPlus() {
        return symbolPlus;
    }

    public char getSymbolMin() {
        return symbolMin;
    }

    public char getSymbolMul() {
        return symbolMul;
    }

    public char getSymbolDiv() {
        return symbolDiv;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public char getUsingSymbol() {
        return usingSymbol;
    }

    public boolean isSymbol() {
        return isSymbol;
    }

    public double getResultNumber() {
        return resultNumber;
    }

    public String getError0() {
        return error0;
    }

    public void addNumber(String useNumber) {
        number = number + useNumber;
    }

    public void createFirstAndSecondNumber() {
        if (number.equals("")) {
            number = "0";
        }
        if (isSymbol) {
            secondNumber = Double.parseDouble(number);
        } else {
            firstNumber = Double.parseDouble(number);
        }

    }

    public void chooseSymbol(char symbol) {
        usingSymbol = symbol;
        isSymbol = true;
        number = "";
    }

    public void result() {
        switch (usingSymbol) {
            case symbolPlus:
                resultNumber = firstNumber + secondNumber;
                break;
            case symbolMin:
                resultNumber = firstNumber - secondNumber;
                break;
            case symbolMul:
                resultNumber = firstNumber * secondNumber;
                break;
            case symbolDiv:
                if (secondNumber == 0) {
                    number = error0;
                } else {
                    resultNumber = firstNumber / secondNumber;
                }
                break;
        }
    }

    public void showResult() {
        NumberFormat nf = new DecimalFormat("#.##########");
        if (number.equals(error0)) {
            isSymbol = false;

        } else {
            number = String.format(Locale.getDefault(), "%s", (nf.format(resultNumber)));
            isSymbol = false;
            createFirstAndSecondNumber();
        }
    }

    public void clearCalculator() {
        number = "";
        isSymbol = false;
        firstNumber = 0;
        secondNumber = 0;
        countPoint = 0;
        resultNumber = 0;
    }

    public boolean counterPoints() {
        return number.indexOf('.') > -1;
    }
}
