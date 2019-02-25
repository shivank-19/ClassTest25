package shivank.classtest25;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button button1, button2;
    Button button3;
    TextView textView;
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
                Toast.makeText(MainActivity.this, "Your payment is Rs. " +s*10, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
