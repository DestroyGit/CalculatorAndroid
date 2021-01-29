package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    // Имя настроек
    private static final String nameSharedPreference = "LOGIN";

    // Имя параметра в настройках
    private static final String calculat = "CALCULAT";

    private static final int lightTheme = 0;
    private static final int darkTheme = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.LightTheme));
        setContentView(R.layout.activity_settings);
        initViews();
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case darkTheme:
                return R.style.DarkTheme;
            default:
                return R.style.LightTheme;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_return:
                finish();
        }
    }

    private void initViews() {
        initRadioButton(findViewById(R.id.radioButtonLightTheme),
                lightTheme);
        initRadioButton(findViewById(R.id.radioButtonDarkTheme),
                darkTheme);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(lightTheme))).setChecked(true);
        initBtnReturn();
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }

    // Сохранение настроек
    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(calculat, codeStyle);
        editor.apply();
    }

    // Чтение настроек, параметр «тема»
    private int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(calculat, codeStyle);
    }

    private void initBtnReturn() {
        Button btnReturn = findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(this);
    }


}