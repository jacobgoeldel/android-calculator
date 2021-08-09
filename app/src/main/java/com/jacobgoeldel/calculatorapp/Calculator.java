package com.jacobgoeldel.calculatorapp;

import java.util.ArrayList;
import java.util.List;

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
}
