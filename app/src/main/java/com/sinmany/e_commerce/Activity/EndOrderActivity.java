package com.sinmany.e_commerce.Activity;

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
        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}
