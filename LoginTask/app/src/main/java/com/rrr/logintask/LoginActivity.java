package com.rrr.logintask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rrr.logintask.apicalls.RetrofitRequest;
import com.rrr.logintask.databinding.ActivityLoginBinding;
import com.rrr.logintask.model.TokenResponse;
import com.rrr.logintask.model.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        pd = new ProgressDialog(this);
        pd.setIcon(R.mipmap.ic_launcher);
        pd.setMessage("Please Wait Loading...");
        pd.setCancelable(false);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                String mail = binding.loginMail.getText().toString();
                String password = binding.loginPassword.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://reqres.in/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitRequest apiData = retrofit.create(RetrofitRequest.class);
                UserLogin user = new UserLogin(mail,password);
                Call<TokenResponse> callData = apiData.login(user);
                callData.enqueue(new Callback<TokenResponse>() {
                    @Override
                    public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                        if (response.body()!=null && response.body().getToken() != null) {
                            pd.dismiss();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<TokenResponse> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
