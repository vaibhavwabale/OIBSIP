package in.vaibhavwabale.unitconverter.ConversionsScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import in.vaibhavwabale.unitconverter.databinding.ActivityAreaConversionBinding;

public class AreaConversion extends AppCompatActivity {

    ActivityAreaConversionBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAreaConversionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.sqMm.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInMM = value * 1000000;
                String str = Float.toString(valueInMM);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.sqCm.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInCM = value * 10000;
                String str = Float.toString(valueInCM);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.sqKm.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInKM = value / 1000000;
                String str = Float.toString(valueInKM);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.hectare.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInHE = value / 10000;
                String str = Float.toString(valueInHE);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });


    }
}