package Domain;

public class CalculatorImp implements Calculator {


    @Override
    public Double performOperation(Double argOne, Double argTwo, Operation operation) {
        switch (operation) {
            case ADD:
                return argOne + argTwo;

            case SUB:
                return argOne - argTwo;

            case MULT:
                return argOne * argTwo;

            case DIV:
                return argOne / argTwo;

            case EQUAL:
            case RESET:



        }
        return 0.0;
    }





}
