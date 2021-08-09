package com.jacobgoeldel.calculatorapp;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    private List<Number> num1;
    private Operation op;
    private List<Number> num2;

    private boolean enteringFirstNumber;

    public Calculator() {
        num1 = new ArrayList<Number>();
        num2 = new ArrayList<Number>();

        op = Operation.NONE;
        enteringFirstNumber = true;
    }

    public void numberClicked(Number number) {
        // decimal is a special case where we want to add a zero in front if there is no number yet
        if(number == Number.DECIMAL) {
            if(enteringFirstNumber) {
                if(num1.size() == 0)
                    num1.add(Number.ZERO);
                num1.add(number);
            } else {
                if(num2.size() == 0)
                    num2.add(Number.ZERO);
                num2.add(number);
            }
            return;
        }

        // we only want the user to be able to enter a zero if the number is not empty. no writing 00001
        if(number == Number.ZERO) {
            if(enteringFirstNumber && num1.size() != 0)
                num1.add(number);
            else if(num2.size() != 0)
                num2.add(number);
            return;
        }

        // every other number is handled the same
        if(enteringFirstNumber) {
            num1.add(number);
        } else {
            num2.add(number);
        }
    }

    public void operationClicked(Operation operation) {
        if(enteringFirstNumber && op == Operation.NONE) {
            // don't set it if the first number is invalid
            if(num1.size() == 0 || num1.get(num1.size() - 1) == Number.DECIMAL)
                return;

            op = operation;
            enteringFirstNumber = false;
        }
    }

    public void clear() {
        num1 = new ArrayList<Number>();
        num2 = new ArrayList<Number>();

        op = Operation.NONE;
        enteringFirstNumber = true;
    }

    private String GetNumberString(Number numb) {
        switch(numb) {
            case ZERO:
                return "0";
            case DECIMAL:
                return ".";
            case ONE:
                return "1";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
        }

        return "?"; // Shouldn't get here
    }

    private String GetOperationString(Operation op) {
        switch(op) {
            case NONE:
                return " ";
            case ADD:
                return " + ";
            case SUBTRACT:
                return " - ";
            case MULTIPLY:
                return " * ";
            case DIVIDE:
                return "/";
            case POWER:
                return "^";
            case MODULUS:
                return " % ";
            case SQUARE_ROOT:
                return " √ ";
        }

        return "?";
    }

    private int OperateIntegerNumbers(int number1, int number2, Operation op) {
        switch(op) {
            case NONE:
                return 0;
            case ADD:
                return number1 + number2;
            case SUBTRACT:
                return number1 - number2;
            case MULTIPLY:
                return number1 * number2;
            case POWER:
                return (int)Math.pow(number1, number2);
            case MODULUS:
                return number1 % number2;
            case DIVIDE: // these will show a decimal regardless of original number types
            case SQUARE_ROOT:
                return -1;
        }

        return -1;
    }

    private double OperateDoubleNumbers(double number1, double number2, Operation op) {
        switch(op) {
            case NONE:
                return 0;
            case ADD:
                return number1 + number2;
            case SUBTRACT:
                return number1 - number2;
            case MULTIPLY:
                return number1 * number2;
            case POWER:
                return Math.pow(number1, number2);
            case MODULUS:
                return number1 % number2;
            case DIVIDE:
                return number1 / number2;
            case SQUARE_ROOT:
                return Math.pow(number1, 1.0/number2);
        }

        return -1;
    }

    public String GetEquationText() {
        String text = "";

        for(Number numb : num1) {
            text += GetNumberString(numb);
        }

        text += GetOperationString(op);

        for(Number numb : num2) {
            text += GetNumberString(numb);
        }

        return text;
    }

    private boolean NumberHasDecimal(List<Number> number) {
        for(Number numb : number) {
            if(numb == Number.DECIMAL)
                return true;
        }

        return false;
    }

    private int GetNumberAsInteger(Number numb) {
        switch(numb) {
            case ZERO:
                return 0;
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
        }

        return -1;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private double GetFullNumberAsDouble(List<Number> number) {
        double numb = 0.0;

        // find the index of the decimal
        int decimalIndex = IntStream.range(0, number.size())
                .filter(i -> number.get(i) == Number.DECIMAL)
                .findFirst().orElse(-1);

        if(decimalIndex == -1)
            return GetFullNumberAsInteger(number);

        // just use the integer code to get the whole number part ex: 13 from 13.56
        numb += GetFullNumberAsInteger(number.subList(0,decimalIndex - 1));

        Log.i("calculator", String.valueOf(numb));

        // get the decimal part
        for(int i = decimalIndex + 1; i < number.size(); i++) {
            numb += GetNumberAsInteger(number.get(i)) * 1/Math.pow(10, i - decimalIndex);
            Log.i("calculator", String.valueOf(numb));
        }

        return numb;
    }

    private int GetFullNumberAsInteger(List<Number> number) {
        int result = 0;

        for(int i = 0; i < number.size(); i++) {
            result += GetNumberAsInteger(number.get(number.size() - 1 - i)) * (int)Math.pow(10, i);
        }

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String GetAnswerText() {
        // check and return if it isn't a complete equation
        if(enteringFirstNumber || num2.size() == 0)
            return "= ";

        // see if we do floats or ints
        if(NumberHasDecimal(num1) || NumberHasDecimal(num2)
                || op == Operation.SQUARE_ROOT || op == Operation.DIVIDE) {
            double firstNumber = GetFullNumberAsDouble(num1);
            double secondNumber = GetFullNumberAsDouble(num2);

            double result = OperateDoubleNumbers(firstNumber, secondNumber, op);

            return "= " + result;
        } else {
            int firstNumber = GetFullNumberAsInteger(num1);
            int secondNumber = GetFullNumberAsInteger(num2);

            int result = OperateIntegerNumbers(firstNumber, secondNumber, op);

            return "= " + result;
        }
    }
}
