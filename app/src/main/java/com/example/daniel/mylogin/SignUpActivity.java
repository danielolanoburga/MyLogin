package com.example.daniel.mylogin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignUpActivity extends AppCompatActivity {

    Button btSave;
    EditText etName, etLastName, etEmail, etBirthDate;
    DatePickerDialog dpBirthDateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = (EditText) findViewById(R.id.etName);
        etLastName = (EditText) findViewById(R.id.etLastname);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etBirthDate = (EditText) findViewById(R.id.etBirthDate);
        etBirthDate.setOnClickListener(voEtBirthDate);

        Calendar calendar = Calendar.getInstance();
        dpBirthDateDialog = new DatePickerDialog(this, doEtBirthDate,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        /*Calendar calendar = Calendar.getInstance();
        dpBirthDateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etBirthDate.setText(DateUtil.dateToString(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));*/

        btSave = (Button) findViewById(R.id.btSave);
        btSave.setOnClickListener(voDoneBtSave);

    }


    DatePickerDialog.OnDateSetListener doEtBirthDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);
            etBirthDate.setText(DateUtil.dateToString(newDate.getTime()));
        }
    };

    View.OnClickListener voEtBirthDate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dpBirthDateDialog.show();
        }
    };

    View.OnClickListener voDoneBtSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(ValidateUtil.isValidate(etName) && ValidateUtil.isValidate(etLastName) && ValidateUtil.isValidate(etEmail)){

                if(ValidateUtil.isEmail(etEmail)){
                    Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                    intent.putExtra("etName", etName.getText().toString().trim());
                    intent.putExtra("etLastName", etLastName.getText().toString().trim());
                    intent.putExtra("etEmail", etEmail.getText().toString().trim());
                    startActivity(intent);
                }
               /* else{
                    // Mostrar alerta de error
                    AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("The email is wrong");
                    alertDialog.show();
                }*/


            }
        }
    };
}
