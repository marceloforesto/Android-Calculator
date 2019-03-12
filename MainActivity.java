package marcelo.foresto.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button div;
    private Button mult;
    private Button sub;
    private Button sum;
    private Button clear;
    private Button equal;
    private TextView result;
    private final char addtion = '+';
    private final char subtraction = '-';
    private final char division = '/';
    private final char multiplication = '*';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private double aux;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "9");
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = addtion;
                result.setText(String.valueOf(val1) + "+");

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = subtraction;
                result.setText(String.valueOf(val1) + "-");
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = multiplication;
                result.setText(String.valueOf(val1) + "*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = division;
                result.setText(String.valueOf(val1) + "/");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = val1;
                compute();
                //ACTION = EQU;
                result.setText(String.valueOf(aux) + String.valueOf(ACTION)  + String.valueOf(val2) + "=" + String.valueOf(val1));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().length() > 0) {
                    CharSequence name = result.getText().toString();
                    result.setText(name.subSequence(0, name.length() -1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    result.setText(null);
                }
            }
        });

        clear.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick (View V){
                val1 = Double.NaN;
                val2 = Double.NaN;
                result.setText(null);
                return true;
            }

        });
    }

    private void setupUIViews() {
        zero = (Button) findViewById(R.id.button0);
        one = (Button) findViewById(R.id.button1);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        nine = (Button) findViewById(R.id.button9);
        sum = (Button) findViewById(R.id.buttonSum);
        sub = (Button) findViewById(R.id.buttonSubtraction);
        div = (Button) findViewById(R.id.buttonDivision);
        mult = (Button) findViewById(R.id.buttonMultiplication);
        equal = (Button) findViewById(R.id.buttonEquality);
        result = (TextView)findViewById(R.id.textView);
        clear = (Button) findViewById(R.id.buttonClear);
    }

    private void compute() {
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(result.getText().toString().substring(result.getText().toString().lastIndexOf(ACTION) + 1));

            switch (ACTION) {
                case addtion:
                    val1 = val1 + val2;
                    break;

                case subtraction:
                    val1 = val1 - val2;
                    break;

                case multiplication:
                    val1 = val1 * val2;
                    break;

                case division:
                    val1 = val1 / val2;
                    break;

                case EQU:
                    break;
            }
        }

        else {
            val1 = Double.parseDouble(result.getText().toString());
        }
    }
}
