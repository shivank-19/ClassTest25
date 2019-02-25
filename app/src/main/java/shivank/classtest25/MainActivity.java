package shivank.classtest25;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button button1, button2;
    Button button3, button4;
    TextView textView;
    CheckBox ch1,ch2;
    int numset;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.quantity);
        button3 = findViewById(R.id.order);
        ch1 = findViewById(R.id.checkBox);
        ch2 = findViewById(R.id.checkBox2);
        button4 = findViewById(R.id.reset);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                numset = numset + 1;
                textView.setText("" + numset);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numset<=0)
                {
                    numset = 0;
                    textView.setText(numset + "");
                }
                else
                {
                    numset = numset - 1;
                    textView.setText("" + numset);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Integer s = Integer.valueOf(textView.getText().toString());
                Integer n;

                if ((s==0)&&((ch1.isChecked())||(ch2.isChecked())))
                {
                    Toast.makeText(MainActivity.this, "Please place Order first then toppings", Toast.LENGTH_SHORT).show();
                }
                else if ((ch1.isChecked())&&(ch2.isChecked()))
                {
                    n = (s * 10) + (s * 5) + (s * 5);
                    Toast.makeText(MainActivity.this, "Your payment is Rs. "+n, Toast.LENGTH_SHORT).show();
                }
                else if (ch1.isChecked())
                {
                    n = (s * 10) + (s * 5);
                    Toast.makeText(MainActivity.this, "Your payment is Rs. "+n, Toast.LENGTH_SHORT).show();

                }
                else if (ch2.isChecked())
                {
                    n = (s * 10) + (s * 5);
                    Toast.makeText(MainActivity.this, "Your payment is Rs. "+n, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    n = (s * 10);
                    Toast.makeText(MainActivity.this, "Your payment is Rs. "+n, Toast.LENGTH_SHORT).show();
                }


            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
}

