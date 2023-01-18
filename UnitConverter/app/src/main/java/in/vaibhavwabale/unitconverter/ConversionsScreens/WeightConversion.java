package in.vaibhavwabale.unitconverter.ConversionsScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import in.vaibhavwabale.unitconverter.databinding.ActivityWeightConversionBinding;

public class WeightConversion extends AppCompatActivity {

    ActivityWeightConversionBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeightConversionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mg.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInMG = value * 1000000;
                String str = Float.toString(valueInMG);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.gm.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInGM = value * 1000;
                String str = Float.toString(valueInGM);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });


    }
}