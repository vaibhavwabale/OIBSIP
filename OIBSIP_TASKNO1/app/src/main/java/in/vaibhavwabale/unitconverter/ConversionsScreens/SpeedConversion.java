package in.vaibhavwabale.unitconverter.ConversionsScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import in.vaibhavwabale.unitconverter.databinding.ActivitySpeedConversionBinding;

public class SpeedConversion extends AppCompatActivity {

    ActivitySpeedConversionBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpeedConversionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.mph.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInMPH = (float) (value * 2.23693);
                String str = Float.toString(valueInMPH);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.kmH.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInKMH = value / 1000;
                String str = Float.toString(valueInKMH);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.kmS.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInKMS = (float) (value * 3.6);
                String str = Float.toString(valueInKMS);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

    }
}