package com.example.daniel.mylogin;

import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by Daniel on 25/03/2016.
 */
public class ValidateUtil {

    private static final String REQUIRED_MSG = "The input field is required";
    private static final String EMAIL_PATTERN_ERROR = "The email pattern is wrong";

    public static boolean isValidate(EditText editText){

        if (editText.getText().toString().trim().length() == 0) {
            editText.setError(REQUIRED_MSG);
            return false;
        }
        return true;
    }

    public static boolean isEmail(EditText editText){
        if(!Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString()).matches()){
            editText.setError(EMAIL_PATTERN_ERROR);
            return false;
        }
        return true;
    }

}
