package lt.vtvpmc.ems.zp18_2.androidcrazyconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText userInput;

    Button btnConvert;
    Button btnReset;

    TextView resultKm;
    TextView resultCm;
    TextView resultMiles;
    TextView resultYards;
    TextView resultFeet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.input_field);

        btnConvert = (Button) findViewById(R.id.buttonConvert);
        btnReset = (Button) findViewById(R.id.buttonReset);

        resultKm = (TextView) findViewById(R.id.kilometre);
        resultCm = (TextView) findViewById(R.id.centimetre);
        resultMiles = (TextView) findViewById(R.id.mile);
        resultYards = (TextView) findViewById(R.id.yard);
        resultFeet = (TextView) findViewById(R.id.feet);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userInputValue;

                try {
                    userInputValue = Integer.parseInt(userInput.getText().toString());
                } catch (Exception ex) {
                    userInputValue = 0;
                    Context context = getApplicationContext();
                    CharSequence text = "Įvesk skaičių!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if (userInputValue > 0) {

                    DecimalFormat df = new DecimalFormat("##.##");

                    resultKm.setText(String.valueOf(df.format(userInputValue / 1000)));
                    resultCm.setText(String.valueOf(df.format(userInputValue)));
                    resultMiles.setText(String.valueOf(df.format(userInputValue / 160934.4)));
                    resultYards.setText(String.valueOf(df.format(userInputValue / 91.44)));
                    resultFeet.setText(String.valueOf(df.format(userInputValue / 30.48)));

                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(null);

                resultKm.setText(R.string.text_result_empty);
                resultCm.setText(R.string.text_result_empty);
                resultMiles.setText(R.string.text_result_empty);
                resultYards.setText(R.string.text_result_empty);
                resultFeet.setText(R.string.text_result_empty);
            }
        });

    }
}
