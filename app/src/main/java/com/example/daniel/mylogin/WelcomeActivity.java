package com.example.daniel.mylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvUsername;
    Button bLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String username = getIntent().getExtras().getString("etUsername");

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvUsername.setText(username);

        bLogout = (Button) findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // Se hizo click en logout
            case R.id.bLogout:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
