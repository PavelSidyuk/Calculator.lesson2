package Ui;

import Domain.Calculator;
import Domain.Operation;

public class CalculatorPresenter {

    private static final int BASE = 10;

    private final CalculatorView view;
    private final Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private Operation previousOperation;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }


    public void onDigitPressed(int digit) {
        if (argTwo == null) {
            argOne = argOne * BASE + digit;

            displayResult(argOne);
        } else {
            argTwo = argTwo * BASE + digit;

            displayResult(argTwo);
        }

    }

    public void onOperationPressed(Operation operation) {

        if (operation != Operation.RESET) {
            if (previousOperation != null) {
                double result = calculator.performOperation(argOne, argTwo, previousOperation);

                displayResult(result);


                argOne = result;

            }
            previousOperation = operation;

            argTwo = 0.0;


        }else {

            argOne = 0.0;
            argTwo = null;
            view.showResult(String.valueOf(0));


        }

    }


    public void displayResult (double arg){

        long longValue = (long) arg;

        if (longValue == arg){
            view.showResult(String.valueOf(longValue));

        }else {
            view.showResult(String.valueOf(arg));

        }


    }
}

