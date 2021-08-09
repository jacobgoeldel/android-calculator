package com.jacobgoeldel.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calculator = new Calculator();

        setContentView(R.layout.activity_main);
    }

    public void updateEquationText() {
        TextView equationText = (TextView) findViewById(R.id.EnteredText);
        equationText.setText(calculator.GetEquationText());

        TextView answerText = (TextView) findViewById(R.id.AnswerText);
        answerText.setText(calculator.GetAnswerText());
    }

    public void zeroClicked(View view) {
        calculator.numberClicked(Number.ZERO);
        updateEquationText();
    }

    public void oneClicked(View view) {
        calculator.numberClicked(Number.ONE);
        updateEquationText();
    }

    public void twoClicked(View view) {
        calculator.numberClicked(Number.TWO);
        updateEquationText();
    }

    public void threeClicked(View view) {
        calculator.numberClicked(Number.THREE);
        updateEquationText();
    }

    public void fourClicked(View view) {
        calculator.numberClicked(Number.FOUR);
        updateEquationText();
    }

    public void fiveClicked(View view) {
        calculator.numberClicked(Number.FIVE);
        updateEquationText();
    }

    public void sixClicked(View view) {
        calculator.numberClicked(Number.SIX);
        updateEquationText();
    }

    public void sevenClicked(View view) {
        calculator.numberClicked(Number.SEVEN);
        updateEquationText();
    }

    public void eightClicked(View view) {
        calculator.numberClicked(Number.EIGHT);
        updateEquationText();
    }

    public void nineClicked(View view) {
        calculator.numberClicked(Number.NINE);
        updateEquationText();
    }

    public void decimalClicked(View view) {
        calculator.numberClicked(Number.DECIMAL);
        updateEquationText();
    }

    public void addClicked(View view) {
        calculator.operationClicked(Operation.ADD);
        updateEquationText();
    }

    public void subtractClicked(View view) {
        calculator.operationClicked(Operation.SUBTRACT);
        updateEquationText();
    }

    public void multiplyClicked(View view) {
        calculator.operationClicked(Operation.MULTIPLY);
        updateEquationText();
    }

    public void divideClicked(View view) {
        calculator.operationClicked(Operation.DIVIDE);
        updateEquationText();
    }

    public void powerClicked(View view) {
        calculator.operationClicked(Operation.POWER);
        updateEquationText();
    }

    public void squareRootClicked(View view) {
        calculator.operationClicked(Operation.SQUARE_ROOT);
        updateEquationText();
    }

    public void modulusClicked(View view) {
        calculator.operationClicked(Operation.MODULUS);
        updateEquationText();
    }

    public void equalsClicked(View view) {
        Log.i("calculator", "equals clicked");
        updateEquationText();
    }

    public void clearClicked(View view) {
        calculator.clear();
        updateEquationText();
    }
}