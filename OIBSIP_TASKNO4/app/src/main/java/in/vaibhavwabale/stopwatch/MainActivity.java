package in.vaibhavwabale.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;

import in.vaibhavwabale.stopwatch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    long time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.timer.setFormat("00:%s");

        binding.start.setOnClickListener(view -> {
            binding.timer.setBase(SystemClock.elapsedRealtime() + time);
            binding.timer.start();
        });

        binding.stop.setOnClickListener(view -> {
            binding.timer.setBase(SystemClock.elapsedRealtime());
            time = 0;
            binding.timer.setFormat("00:%s");
            binding.timer.stop();
        });

        binding.hold.setOnClickListener(view -> {
            time = binding.timer.getBase() - SystemClock.elapsedRealtime();
            binding.timer.stop();
        });


    }
}