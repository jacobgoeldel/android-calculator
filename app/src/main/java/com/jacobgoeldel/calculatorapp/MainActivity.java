package com.jacobgoeldel.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zeroClicked(View view) {
        Log.i("calculator", "zero clicked");
    }

    public void oneClicked(View view) {
        Log.i("calculator", "one clicked");
    }

    public void twoClicked(View view) {
        Log.i("calculator", "two clicked");
    }

    public void threeClicked(View view) {
        Log.i("calculator", "three clicked");
    }

    public void fourClicked(View view) {
        Log.i("calculator", "four clicked");
    }

    public void fiveClicked(View view) {
        Log.i("calculator", "five clicked");
    }

    public void sixClicked(View view) {
        Log.i("calculator", "six clicked");
    }

    public void sevenClicked(View view) {
        Log.i("calculator", "seven clicked");
    }

    public void eightClicked(View view) {
        Log.i("calculator", "eight clicked");
    }

    public void nineClicked(View view) {
        Log.i("calculator", "nine clicked");
    }

    public void decimalClicked(View view) {
        Log.i("calculator", "decimal clicked");
    }

    public void addClicked(View view) {
        Log.i("calculator", "add clicked");
    }

    public void subtractClicked(View view) {
        Log.i("calculator", "subtract clicked");
    }

    public void multiplyClicked(View view) {
        Log.i("calculator", "multiply clicked");
    }

    public void divideClicked(View view) {
        Log.i("calculator", "divide clicked");
    }

    public void powerClicked(View view) {
        Log.i("calculator", "power clicked");
    }

    public void squareRootClicked(View view) {
        Log.i("calculator", "square root clicked");
    }

    public void modulusClicked(View view) {
        Log.i("calculator", "modulus clicked");
    }

    public void equalsClicked(View view) {
        Log.i("calculator", "equals clicked");
    }

    public void clearClicked(View view) {
        Log.i("calculator", "clear clicked");
    }
}