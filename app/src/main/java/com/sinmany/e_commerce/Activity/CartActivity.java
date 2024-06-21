package com.sinmany.e_commerce.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sinmany.e_commerce.Adapter.CartAdapter;
import com.sinmany.e_commerce.Helper.ManagmentCart;
import com.sinmany.e_commerce.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {

    private ManagmentCart managmentCart;
    ActivityCartBinding binding;
    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managmentCart = new ManagmentCart(this);
        buttonNameNavigation();
        setVariable();
        initList();
    }

    private void buttonNameNavigation() {
        binding.orderBtn.setOnClickListener(v -> startActivity(new Intent(CartActivity.this, EndOrderActivity.class)));
    }

    private void initList() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scroll.setVisibility(View.GONE);
        }else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scroll.setVisibility(View.VISIBLE);
        }

        binding.cartView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), () -> culculatorCart()));
    }

    private void culculatorCart(){
        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round(managmentCart.getTotalFee()*percentTax*100)/100;

        double total = Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal = Math.round(managmentCart.getTotalFee()*100)/100;

        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTxt.setText("$"+tax);
        binding.deliveryTxt.setText("$"+delivery);
        binding.totalTxt.setText("$"+total);

    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}