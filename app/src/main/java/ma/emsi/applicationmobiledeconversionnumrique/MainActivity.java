package ma.emsi.applicationmobiledeconversionnumrique;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Spinner inputBase;
    private Spinner outputBase;
    private Button convertButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        inputBase = findViewById(R.id.inputBase);
        outputBase = findViewById(R.id.outputBase);
        convertButton = findViewById(R.id.convertButton);
        resultView = findViewById(R.id.resultView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber();
            }
        });
    }

    private void convertNumber() {
        String number = inputNumber.getText().toString();
        String inputBaseValue = inputBase.getSelectedItem().toString();
        String outputBaseValue = outputBase.getSelectedItem().toString();

        int inputBaseInt = getBaseValue(inputBaseValue);
        int outputBaseInt = getBaseValue(outputBaseValue);

        try {
            int decimalValue = Integer.parseInt(number, inputBaseInt);
            String result = Integer.toString(decimalValue, outputBaseInt);
            resultView.setText(result);
        } catch (NumberFormatException e) {
            resultView.setText("Invalid input");
        }
    }

    private int getBaseValue(String base) {
        switch (base) {
            case "Binary":
                return 2;
            case "Octal":
                return 8;
            case "Decimal":
                return 10;
            case "Hexadecimal":
                return 16;
            default:
                return 10;
        }
    }
}