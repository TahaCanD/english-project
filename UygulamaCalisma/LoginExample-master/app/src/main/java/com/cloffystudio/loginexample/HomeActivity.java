package com.cloffystudio.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cloffystudio.loginexample.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Intent ile gelen verileri al
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        boolean isRemember = intent.getBooleanExtra("isRemember", false);

        // Kullanıcı bilgilerini ekranda göster
        binding.emailTextView.setText("Email: " + email);
        binding.passwordTextView.setText("Şifre: " + password);
        binding.rememberTextView.setText("Beni Hatırla: " + (isRemember ? "Evet" : "Hayır"));

        // Çıkış butonu
        binding.logoutButton.setOnClickListener(v -> {
            Toast.makeText(HomeActivity.this, "Çıkış yapıldı.", Toast.LENGTH_SHORT).show();
            finish(); // Aktiviteyi kapat
        });
    }
}
