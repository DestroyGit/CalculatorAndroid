package com.example.calculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView calculator;
    private Calculation calculation = new Calculation();
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonPlus;
    private Button buttonMin;
    private Button buttonMul;
    private Button buttonDiv;
    private Button buttonEqu;
    private Button buttonPoi;
    private Button buttonPer;
    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/TimesNewRomanEcofontBoldItalic.ttf");
        TextView calcView = findViewById(R.id.calc);
        calcView.setTypeface(tf);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number0:
                calculation.addNumber(calculation.getNumber0());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number1:
                calculation.addNumber(calculation.getNumber1());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number2:
                calculation.addNumber(calculation.getNumber2());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number3:
                calculation.addNumber(calculation.getNumber3());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number4:
                calculation.addNumber(calculation.getNumber4());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number5:
                calculation.addNumber(calculation.getNumber5());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number6:
                calculation.addNumber(calculation.getNumber6());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number7:
                calculation.addNumber(calculation.getNumber7());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number8:
                calculation.addNumber(calculation.getNumber8());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.number9:
                calculation.addNumber(calculation.getNumber9());
                setTextCalculator(calculation.getNumber());
                break;
            case R.id.symbol_poi:
                calculation.addNumber(calculation.getSymbolPoi());
                setTextCalculator(calculation.getNumber());
                blockButtonPoint(calculation.counterPoints());
                break;
            case R.id.symbol_plus:
                blockButtonPoint(false);
                calculation.createFirstAndSecondNumber();
                calculation.chooseSymbol(calculation.getSymbolPlus());
                break;
            case R.id.symbol_min:
                blockButtonPoint(false);
                calculation.createFirstAndSecondNumber();
                calculation.chooseSymbol(calculation.getSymbolMin());
                break;
            case R.id.symbol_mul:
                blockButtonPoint(false);
                calculation.createFirstAndSecondNumber();
                calculation.chooseSymbol(calculation.getSymbolMul());
                break;
            case R.id.symbol_div:
                blockButtonPoint(false);
                calculation.createFirstAndSecondNumber();
                calculation.chooseSymbol(calculation.getSymbolDiv());
                break;
            case R.id.symbol_equ:
                calculation.createFirstAndSecondNumber();
                calculation.result();
                calculation.showResult();
                setTextCalculator(calculation.getNumber());
                if (calculation.getNumber().equals(calculation.getError0())) {
                    blockButtons(false);
                }
                blockButtonPoint(calculation.counterPoints());
                break;
            case R.id.symbol_clear:
                blockButtons(true); //разблокировка кнопок, если были какие-то заблокированы
                calculation.clearCalculator();
                setTextCalculator(calculation.getNumber());
                break;
        }
    }

    private void blockButtons(boolean block) {
        button0.setEnabled(block);
        button1.setEnabled(block);
        button2.setEnabled(block);
        button3.setEnabled(block);
        button4.setEnabled(block);
        button5.setEnabled(block);
        button6.setEnabled(block);
        button7.setEnabled(block);
        button8.setEnabled(block);
        button9.setEnabled(block);
        buttonPoi.setEnabled(block);
        buttonPer.setEnabled(block);
        buttonPlus.setEnabled(block);
        buttonMin.setEnabled(block);
        buttonMul.setEnabled(block);
        buttonDiv.setEnabled(block);
        buttonEqu.setEnabled(block);
    }

    private void blockButtonPoint(boolean block) {
        buttonPoi.setEnabled(!block);
    }

    private void initViews() {
        calculator = findViewById(R.id.calc);
        initButton0();
        initButton1();
        initButton2();
        initButton3();
        initButton4();
        initButton5();
        initButton6();
        initButton7();
        initButton8();
        initButton9();
        initButtonPlus();
        initButtonMinus();
        initButtonMultiply();
        initButtonDivision();
        initButtonEqually();
        initButtonPoint();
        initButtonPercent();
        initButtonClear();
    }

    private void setTextCalculator(String number) {
        calculator.setText(String.format(Locale.getDefault(), "%s", number));
    }

    private void initButton0() {
        button0 = findViewById(R.id.number0);
        button0.setOnClickListener(this);
    }

    private void initButton1() {
        button1 = findViewById(R.id.number1);
        button1.setOnClickListener(this);
    }

    private void initButton2() {
        button2 = findViewById(R.id.number2);
        button2.setOnClickListener(this);
    }

    private void initButton3() {
        button3 = findViewById(R.id.number3);
        button3.setOnClickListener(this);
    }

    private void initButton4() {
        button4 = findViewById(R.id.number4);
        button4.setOnClickListener(this);
    }

    private void initButton5() {
        button5 = findViewById(R.id.number5);
        button5.setOnClickListener(this);
    }

    private void initButton6() {
        button6 = findViewById(R.id.number6);
        button6.setOnClickListener(this);
    }

    private void initButton7() {
        button7 = findViewById(R.id.number7);
        button7.setOnClickListener(this);
    }

    private void initButton8() {
        button8 = findViewById(R.id.number8);
        button8.setOnClickListener(this);
    }

    private void initButton9() {
        button9 = findViewById(R.id.number9);
        button9.setOnClickListener(this);
    }

    private void initButtonPoint() {
        buttonPoi = findViewById(R.id.symbol_poi);
        buttonPoi.setOnClickListener(this);
    }

    private void initButtonPercent() {
        buttonPer = findViewById(R.id.symbol_per);
        buttonPer.setOnClickListener(this);
    }

    private void initButtonClear() {
        buttonClear = findViewById(R.id.symbol_clear);
        buttonClear.setOnClickListener(this);
    }

    private void initButtonPlus() {
        buttonPlus = findViewById(R.id.symbol_plus);
        buttonPlus.setOnClickListener(this);
    }

    private void initButtonMinus() {
        buttonMin = findViewById(R.id.symbol_min);
        buttonMin.setOnClickListener(this);
    }

    private void initButtonMultiply() {
        buttonMul = findViewById(R.id.symbol_mul);
        buttonMul.setOnClickListener(this);
    }

    private void initButtonDivision() {
        buttonDiv = findViewById(R.id.symbol_div);
        buttonDiv.setOnClickListener(this);
    }

    private void initButtonEqually() {
        buttonEqu = findViewById(R.id.symbol_equ);
        buttonEqu.setOnClickListener(this);
    }
}