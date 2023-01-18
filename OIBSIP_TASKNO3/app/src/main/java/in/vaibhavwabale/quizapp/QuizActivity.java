package in.vaibhavwabale.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import in.vaibhavwabale.quizapp.Models.Questions;
import in.vaibhavwabale.quizapp.databinding.ActivityQuizBinding;

public class QuizActivity extends AppCompatActivity {

    Boolean timerAgain = true;
    CountDownTimer countDownTimer;
    ActivityQuizBinding binding;
    List<Questions> questionsList;
    int score = 0;
    int position = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (this.timerAgain) {
            reverseTimer(binding.timer);
        }
        timerAgain = false;


        questionsList = new ArrayList<Questions>() {
            {
                add(new Questions("Choose the correct option related to Android.", "Android is an Operating System", "Android is a web browser", "Android is an Operating System", "Android is a web server", "None"));
                add(new Questions("What is an activity in android?", "A single screen in an application with supporting java code", "android class", "android package", "A single screen in an application with supporting java code", "None of the above"));
                add(new Questions("Among the following options choose the one for which android is based on linux.", "All of the above", "Networking", "Portability", "Security", "All of the above"));
                add(new Questions("Among the below virtual machines choose the one which is used by the Android operating system", "Dalvik operating system", "Dalvik operating system", "JVM", "Simple virtual machine", "None"));
                add(new Questions("Identify the language on which Android is based upon.", "Java", "Python", "C++", "Java", "None"));
            }
        };

        if (questionsList.size() > 0) {
            loadQuestion(binding.question, 0, questionsList.get(position).getQuestion());

            for (int i = 0; i < 4; i++) {
                binding.container.getChildAt(i).setOnClickListener(v -> checkAns((Button) v));
            }

            binding.nextBtn.setOnClickListener(v -> {
                binding.nextBtn.setEnabled(false);
                binding.nextBtn.setAlpha(0.7f);
                enabled(true);
                position++;

                if (position == questionsList.size()) {
                    Intent i = new Intent(this, ScoreActivity.class);
                    i.putExtra("score", score);
                    i.putExtra("total", questionsList.size());
                    startActivity(i);
                    finish();
                    return;
                }
                count = 0;
                loadQuestion(binding.question, 0, questionsList.get(position).getQuestion());

            });

            binding.shareBtn.setOnClickListener(v -> {
                String body = "*" + questionsList.get(position).getQuestion() + "*\n" +
                        "(a) " + questionsList.get(position).getoA() + "\n" +
                        "(b) " + questionsList.get(position).getoB() + "\n" +
                        "(c) " + questionsList.get(position).getoC() + "\n" +
                        "(d) " + questionsList.get(position).getoD();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("Text/Plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Quiz");
                i.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(i, "Share via"));
            });


        }
    }


    private void reverseTimer(TextView textView) {

        final TextView textView1 = textView;
        countDownTimer = new CountDownTimer((120 * 1000) + 1000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long j) {
                NumberFormat f = new DecimalFormat("00");
                long min = (j / 60000) % 60;
                long sec = (j / 1000) % 60;
                textView1.setText(f.format(min) + ":" + f.format(sec));
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                textView1.setText("00:00");
                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questionsList.size());
                startActivity(intent);
                finish();

            }
        }.start();
    }

    private void checkAns(Button selectedOption) {
        enabled(false);
        binding.nextBtn.setEnabled(true);
        binding.nextBtn.setAlpha(1.0f);
        if (selectedOption.getText().toString().equals(questionsList.get(position).getAnswers())) {
            score++;
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4caf50")));
            return;
        }
        selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
        this.binding.container.findViewWithTag(this.questionsList.get(this.position).getAnswers()).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
    }

    private void enabled(Boolean enable) {
        for (int i = 0; i < 4; i++) {
            binding.container.getChildAt(i).setEnabled(enable);
            if (enable) {
                binding.container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00aeff")));
            }
        }
    }

    private void loadQuestion(View view, int value, String data) {
        for (int i = 0; i < 4; i++) {
            binding.container.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00aeff")));
        }
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (value == 0 && count < 4) {
                            String option = "";
                            if (count == 0)
                                option = questionsList.get(position).getoA();
                            else if (count == 1)
                                option = questionsList.get(position).getoB();
                            else if (count == 2)
                                option = questionsList.get(position).getoC();
                            else if (count == 3)
                                option = questionsList.get(position).getoD();

                            loadQuestion(binding.container.getChildAt(count), 0, option);
                            count++;
                        }
                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onAnimationEnd(Animator animation) {

                        if (value == 0) {
                            try {
                                ((TextView) view).setText(data);
                                binding.indicator.setText(position + "/" + questionsList.size());
                            } catch (ClassCastException e) {
                                ((Button) view).setText(data);
                            }
                            view.setTag(data);
                            loadQuestion(view, 1, data);

                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", (dialog, which) -> finish());
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
        countDownTimer.cancel();
    }

}