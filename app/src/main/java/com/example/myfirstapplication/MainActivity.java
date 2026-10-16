package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView outputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userInput = findViewById(R.id.uvin123);
        Button clickBtn = findViewById(R.id.btid123);
        outputTxt = findViewById(R.id.nameId);

        clickBtn.setOnClickListener(v -> {
            String inputName = userInput.getText().toString().trim();
            if (!inputName.isEmpty()) {
                outputTxt.setText(inputName);
            } else {
                outputTxt.setText(getString(R.string.default_user_name));
            }
        });
    }
}
