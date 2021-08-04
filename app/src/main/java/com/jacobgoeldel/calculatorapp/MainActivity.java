package com.jacobgoeldel.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calculator = new Calculator();

        setContentView(R.layout.activity_main);
    }

    public void zeroClicked(View view) {
        calculator.numberClicked(Number.ZERO);
    }

    public void oneClicked(View view) {
        calculator.numberClicked(Number.ONE);
    }

    public void twoClicked(View view) {
        calculator.numberClicked(Number.TWO);
    }

    public void threeClicked(View view) {
        calculator.numberClicked(Number.THREE);
    }

    public void fourClicked(View view) {
        calculator.numberClicked(Number.FOUR);
    }

    public void fiveClicked(View view) {
        calculator.numberClicked(Number.FIVE);
    }

    public void sixClicked(View view) {
        calculator.numberClicked(Number.SIX);
    }

    public void sevenClicked(View view) {
        calculator.numberClicked(Number.SEVEN);
    }

    public void eightClicked(View view) {
        calculator.numberClicked(Number.EIGHT);
    }

    public void nineClicked(View view) {
        calculator.numberClicked(Number.NINE);
    }

    public void decimalClicked(View view) {
        calculator.numberClicked(Number.DECIMAL);
    }

    public void addClicked(View view) {
        calculator.operationClicked(Operation.ADD);
    }

    public void subtractClicked(View view) {
        calculator.operationClicked(Operation.SUBTRACT);
    }

    public void multiplyClicked(View view) {
        calculator.operationClicked(Operation.MULTIPLY);
    }

    public void divideClicked(View view) {
        calculator.operationClicked(Operation.DIVIDE);
    }

    public void powerClicked(View view) {
        calculator.operationClicked(Operation.POWER);
    }

    public void squareRootClicked(View view) {
        calculator.operationClicked(Operation.SQUARE_ROOT);
    }

    public void modulusClicked(View view) {
        calculator.operationClicked(Operation.MODULUS);
    }

    public void equalsClicked(View view) {
        Log.i("calculator", "equals clicked");
    }

    public void clearClicked(View view) {
        Log.i("calculator", "clear clicked");
    }
}