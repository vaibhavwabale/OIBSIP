package in.vaibhavwabale.unitconverter.ConversionsScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import in.vaibhavwabale.unitconverter.databinding.ActivityVolumeConversionBinding;

public class VolumeConversion extends AppCompatActivity {

    ActivityVolumeConversionBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVolumeConversionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.cubicCm.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInCUBECM = value * 1000000;
                String str = Float.toString(valueInCUBECM);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.millilitre.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInML = value * 1000000;
                String str = Float.toString(valueInML);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });

        binding.litre.setOnClickListener(view -> {
            String val = binding.input.getText().toString();
            if (!val.equals("")) {
                float value = Float.parseFloat(val);
                float valueInL = value * 1000;
                String str = Float.toString(valueInL);
                binding.result.setText("Answer is " + str);
            } else {
                binding.result.setText("No Input Entered");
            }
        });


    }
}