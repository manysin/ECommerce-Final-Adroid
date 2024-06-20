package com.sinmany.e_commerce.Activity;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sinmany.e_commerce.Adapter.PopularAdapter;
import com.sinmany.e_commerce.R;
import com.sinmany.e_commerce.databinding.ActivityMainBinding;
import com.sinmany.e_commerce.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statuseBarColor();
        initRecycleView();
    }

    private void statuseBarColor() {
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_Dark));

    }

    private void initRecycleView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-Shirt-Black", "item_1",15,4,500,"Description"));
        items.add(new PopularDomain("Smart Watch", "item_2",10,1.5,450,""));
        items.add(new PopularDomain("Phone", "item_3",3,4.9,800,""));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}