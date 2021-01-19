package com.example.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculation {
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String number = "";
    private String number0 = "0";
    private String number1 = "1";
    private String number2 = "2";
    private String number3 = "3";
    private String number4 = "4";
    private String number5 = "5";
    private String number6 = "6";
    private String number7 = "7";
    private String number8 = "8";
    private String number9 = "9";
    private String symbolPoi = ".";
    private final char symbolPlus = '+';
    private final char symbolMin = '-';
    private final char symbolMul = '*';
    private final char symbolDiv = '=';
    private char usingSymbol;
    private boolean isSymbol = false;
    private double resultNumber = 0;
    private String error0 = "ERROR: деление на ноль";
    private int countPoint = 0;

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
