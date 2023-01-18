package in.vaibhavwabale.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import in.vaibhavwabale.quizapp.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;

    int score, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        score = getIntent().getIntExtra("score", 0);
        total = getIntent().getIntExtra("total", 0);

        binding.score.setText(String.valueOf(score));
        binding.total.setText(String.valueOf(total));

    }
}