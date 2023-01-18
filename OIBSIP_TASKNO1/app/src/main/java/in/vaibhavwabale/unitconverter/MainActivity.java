package in.vaibhavwabale.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import in.vaibhavwabale.unitconverter.ConversionsScreens.AreaConversion;
import in.vaibhavwabale.unitconverter.ConversionsScreens.LengthConversion;
import in.vaibhavwabale.unitconverter.ConversionsScreens.SpeedConversion;
import in.vaibhavwabale.unitconverter.ConversionsScreens.TemperatureConversion;
import in.vaibhavwabale.unitconverter.ConversionsScreens.VolumeConversion;
import in.vaibhavwabale.unitconverter.ConversionsScreens.WeightConversion;
import in.vaibhavwabale.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.area.setOnClickListener(view ->
                startActivity(new Intent(this, AreaConversion.class)));

        binding.length.setOnClickListener(view ->
                startActivity(new Intent(this, LengthConversion.class)));

        binding.speed.setOnClickListener(view ->
                startActivity(new Intent(this, SpeedConversion.class)));

        binding.temperature.setOnClickListener(view ->
                startActivity(new Intent(this, TemperatureConversion.class)));

        binding.volume.setOnClickListener(view ->
                startActivity(new Intent(this, VolumeConversion.class)));

        binding.weight.setOnClickListener(view ->
                startActivity(new Intent(this, WeightConversion.class)));


    }
}