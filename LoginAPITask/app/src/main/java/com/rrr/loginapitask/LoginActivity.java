package com.rrr.loginapitask;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rrr.loginapitask.model.LoginApi;
import com.rrr.loginapitask.model.TokenResponse;
import com.rrr.loginapitask.model.UserLogin;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;
    Button login;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        loading = findViewById(R.id.loading);
    }

    public void loginAccount(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitRequest apiData = retrofit.create(RetrofitRequest.class);
        UserLogin user = new UserLogin(userName.getText().toString(), password.getText().toString());
        Call<TokenResponse> callData = apiData.login(user);
        callData.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.body() !=null && response.body().getToken() != null ) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
