package com.cloffystudio.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.cloffystudio.loginexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    
    User user;

    private boolean isRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String email = binding.emailEditText.getText().toString();
                String password = binding.passwordEditText.getText().toString();

                if (user == null){
                    Toast.makeText(MainActivity.this, "Lütfen giriş yapmadan önce kayıt olunuz...", Toast.LENGTH_SHORT).show();
                } else if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    intent.putExtra("isRemember", binding.rememberSwitch.isChecked());
                    startActivity(intent);
                    finish();
                }else{

                    Toast.makeText(MainActivity.this, "Email veya şifre yanlış!", Toast.LENGTH_SHORT).show();

                }



            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String email = binding.emailEditText.getText().toString();
                String pasword = binding.passwordEditText.getText().toString();
                
                if(email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Email boş bırakılamaz.", Toast.LENGTH_SHORT).show();
                } else if (pasword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Şifre boş bırakılamaz.", Toast.LENGTH_SHORT).show();
                } else if (user != null) {
                    Toast.makeText(MainActivity.this, "Daha önce kayıt oldunuz.", Toast.LENGTH_SHORT).show();
                }else {
                    user = new User(email, pasword);

                    Toast.makeText(MainActivity.this, "Kayıt başarılı.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}