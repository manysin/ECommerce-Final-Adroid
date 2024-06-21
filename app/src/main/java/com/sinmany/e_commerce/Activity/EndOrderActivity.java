package com.sinmany.e_commerce.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.sinmany.e_commerce.databinding.ActivityEndOrderBinding;

public class EndOrderActivity extends AppCompatActivity {
    ActivityEndOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEndOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        buttonNameNavigation();
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }

    private void buttonNameNavigation() {
        binding.btnBackHome.setOnClickListener(v -> startActivity(new Intent(EndOrderActivity.this, MainActivity.class)));
    }
}
