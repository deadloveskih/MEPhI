package com.example.mephi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mephi.API.NetworkService;
import com.example.mephi.API.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button login;
    TextView forgot_pass;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.button_login);
        forgot_pass = findViewById(R.id.forgot_pass);
        email = findViewById(R.id.field_email);

        Call<model> call = NetworkService.getInstance().getMyApi().getLesson();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(@NonNull Call<model> call, @NonNull Response<model> response) {
                if (response.code() == 200) {
                    model m = response.body();
                }
            }

            @Override
            public void onFailure(@NonNull Call<model> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}