package Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculatorlesson2.R;

import java.util.HashMap;
import java.util.Map;

import Domain.CalculatorImp;
import Domain.Operation;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView textResult;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImp());

        textResult = findViewById(R.id.text);
        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDigitPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.key_0).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_1).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitsClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitsClickListener);


        Map<Integer, Operation> operations = new HashMap<>();
        operations.put(R.id.key_addition, Operation.ADD);
        operations.put(R.id.key_subtraction,Operation.SUB );
        operations.put(R.id.key_division, Operation.DIV);
        operations.put(R.id.key_multiplication, Operation.MULT);
        operations.put(R.id.key_reset,Operation.RESET);

        View.OnClickListener operationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperationPressed(operations.get(v.getId()));

            }
        };

        findViewById(R.id.key_addition).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_subtraction).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_division).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_multiplication).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_equally).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_reset).setOnClickListener(operationsClickListener);
    }


    @Override
    public void showResult(String result) {
        textResult.setText(result);
    }
}