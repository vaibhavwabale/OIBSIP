package in.vaibhavwabale.unitconverter.ConversionsScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import in.vaibhavwabale.unitconverter.databinding.ActivityTemperatureConversionBinding;

public class TemperatureConversion extends AppCompatActivity {

    ActivityTemperatureConversionBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTemperatureConversionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.kelvin.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInK = (float) (value * 274.15);
                String str = Float.toString(valueInK);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.fahrenheit.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInF = (float) (value * 33.8);
                String str = Float.toString(valueInF);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });


    }
}