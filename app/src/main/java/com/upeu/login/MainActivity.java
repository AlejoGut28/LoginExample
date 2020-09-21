package com.upeu.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private Button bt;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.password);
        bt = (Button) findViewById(R.id.save);
        sp = getSharedPreferences( "SHARED_PREF", MODE_PRIVATE);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userView = user.getText().toString();
                String pasView = pass.getText().toString();

                SharedPreferences.Editor editor =  sp.edit();
                editor.putString("USERVIEW", userView);
                editor.putString("PASVIEW", pasView);
                editor.apply();

                Toast.makeText( MainActivity.this, "Informacion Registrada", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, UserRegister.class);
                startActivity(intent);
                finish();
            }
        });
    }
}