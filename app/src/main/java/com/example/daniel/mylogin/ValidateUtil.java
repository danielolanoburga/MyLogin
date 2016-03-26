package com.example.daniel.mylogin;

import android.widget.EditText;

/**
 * Created by Daniel on 25/03/2016.
 */
public class ValidateUtil {

    private static final String REQUIRED_MSG = "The input field is required";

    public static boolean isValidate(EditText editText){

        if (editText.getText().toString().trim().length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }
        return true;

    }
}
