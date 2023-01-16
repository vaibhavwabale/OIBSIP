package in.vaibhavwabale.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;

import in.vaibhavwabale.mycalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private final String EQU = "=";
    private final String EXTRA = "@";
    private final String MODULUS = "%";
    private String ACTION;
    private double val1 = Double.NaN;
    private double val2;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button0.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "0");
        });

        binding.button1.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "1");
        });

        binding.button2.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "2");
        });

        binding.button3.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "3");
        });

        binding.button4.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "4");
        });

        binding.button5.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "5");
        });

        binding.button6.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "6");
        });

        binding.button7.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "7");
        });

        binding.button8.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "8");
        });

        binding.button9.setOnClickListener(v -> {
            ifErrorOnOutput();
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + "9");
        });

        binding.buttonDot.setOnClickListener(v -> {
            exceedLength();
            binding.input.setText(binding.input.getText().toString() + ".");

        });

        binding.buttonPara1.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                ACTION = MODULUS;
                operation();
                if (!ifReallyDecimal()) {
                    binding.output.setText(val1 + "%");
                } else {
                    binding.output.setText((int) val1 + "%");
                }
                binding.input.setText(null);
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonPara2.setOnClickListener(view -> {
            if (!binding.output.getText().toString().isEmpty() || !binding.input.getText().toString().isEmpty()) {
                val1 = Double.parseDouble(binding.input.getText().toString());
                ACTION = EXTRA;
                binding.output.setText("-" + binding.input.getText().toString());
                binding.input.setText("");
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonAdd.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                ACTION = ADDITION;
                operation();
                if (!ifReallyDecimal()) {
                    binding.output.setText(val1 + "+");
                } else {
                    binding.output.setText((int) val1 + "+");
                }
                binding.input.setText(null);
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonSub.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                ACTION = SUBTRACTION;
                operation();
                if (!ifReallyDecimal()) {
                    binding.output.setText(val1 + "-");
                } else {
                    binding.output.setText((int) val1 + "-");
                }
                binding.input.setText(null);
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonMulti.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                ACTION = MULTIPLICATION;
                operation();
                if (!ifReallyDecimal()) {
                    binding.output.setText(val1 + "*");
                } else {
                    binding.output.setText((int) val1 + "*");
                }
                binding.input.setText(null);
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonDivide.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                ACTION = DIVISION;
                operation();
                if (!ifReallyDecimal()) {
                    binding.output.setText(val1 + "/");
                } else {
                    binding.output.setText((int) val1 + "/");
                }
                binding.input.setText(null);
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonEqual.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                operation();
                ACTION = EQU;
                if (!ifReallyDecimal()) {
                    binding.output.setText(String.valueOf(val1));
                } else {
                    binding.output.setText(String.valueOf((int) val1));
                }
                binding.input.setText(null);
            } else {
                binding.output.setText("Error");
            }
        });

        binding.buttonClear.setOnClickListener(v -> {
            if (binding.input.getText().length() > 0) {
                CharSequence name = binding.input.getText().toString();
                binding.input.setText(name.subSequence(0, name.length() - 1));
            } else {
                val1 = Double.NaN;
                val2 = Double.NaN;
                binding.input.setText("");
                binding.output.setText("");
            }
        });

        binding.buttonClear.setOnLongClickListener(v -> {
            val1 = Double.NaN;
            val2 = Double.NaN;
            binding.input.setText("");
            binding.output.setText("");
            return true;
        });


    }

    private void operation() {
        if (!Double.isNaN(val1)) {
            if (binding.output.getText().toString().charAt(0) == '-') {
                val1 = (-1) * val1;
            }
            val2 = Double.parseDouble(binding.input.getText().toString());
            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EXTRA:
                    val1 = (-1) * val1;
                    break;
                case MODULUS:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(binding.input.getText().toString());
        }
    }

    private void ifErrorOnOutput() {
        if (binding.output.getText().toString().equals("Error")) {
            binding.output.setText("");
        }
    }

    private boolean ifReallyDecimal() {
        return val1 == (int) val1;
    }

    private void exceedLength() {
        if (binding.input.getText().toString().length() > 10) {
            binding.input.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }


}