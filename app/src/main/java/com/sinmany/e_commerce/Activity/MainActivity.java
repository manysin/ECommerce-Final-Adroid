package com.sinmany.e_commerce.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        buttonNameNavigation();
    }

    private void buttonNameNavigation() {
        binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void statuseBarColor() {
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_Dark));

    }

    private void initRecycleView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-Shirt-Black", "item_1",15,4,500,"This classic black T-shirt is made from 100% soft cotton, offering comfort and breathability for everyday wear. It features a crew neck and short sleeves, with a relaxed fit that suits any casual outfit. The shirt is durable and easy to care for, making it a versatile addition to any wardrobe."));
        items.add(new PopularDomain("Smart Watch", "item_2",10,1.5,450,"This stylish watch combines functionality with elegance. It has a sleek stainless steel case and a durable leather strap, ensuring long-lasting use. The watch features a clear analog display with luminous hands, a date window, and water resistance up to 50 meters, making it perfect for both everyday wear and special occasions."));
        items.add(new PopularDomain("Phone", "item_3",3,4.9,800,"This smartphone boasts a high-resolution 6.5-inch display, offering vibrant colors and sharp images for an immersive viewing experience. It is powered by a fast processor and comes with ample storage space, ensuring smooth performance for all your apps and media."));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}