package com.example.daniel.mylogin;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin, bSignUp;
    EditText etUsername, etPassword;

    private static final String REQUIRED_MSG = "The input field is required";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        bSignUp = (Button) findViewById(R.id.bSignUp);

        bLogin.setOnClickListener(this);
        bSignUp.setOnClickListener(voDoneSignUp);

    }


    View.OnClickListener voDoneSignUp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // Si se hace click en el boton Login
            case R.id.bLogin:

                // Validar inputs required
                if(ValidateUtil.isValidate(etUsername) && ValidateUtil.isValidate(etPassword)){
                        // Validar accesos
                    if(etUsername.getText().toString().trim().equals("admin") && etPassword.getText().toString().trim().equals("admin")){
                        // Mostrar pantalla de Bienvenida
                        Intent intentLogin = new Intent(this, WelcomeActivity.class);
                        intentLogin.putExtra("etUsername", etUsername.getText().toString().trim());
                        startActivity(intentLogin);
                    }else{
                        // Mostrar alerta de error
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("The credentials are wrong");
                        alertDialog.show();
                    }

                }

                break;
        }
    }

}
