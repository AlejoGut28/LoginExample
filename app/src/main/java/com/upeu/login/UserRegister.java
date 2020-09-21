package com.upeu.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserRegister extends AppCompatActivity {

    TextView user;
    Button bt;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        user = findViewById(R.id.user);
        bt = findViewById(R.id.logout);

        sp = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        String userName  = sp.getString("USERVIEW", "");
        user.setText(userName);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(UserRegister.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}