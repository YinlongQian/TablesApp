package com.msushanth.tablesapp.ViewLayer.Account;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.msushanth.tablesapp.ControllerLayer.AccountController;
import com.msushanth.tablesapp.R;

/**
 * Created by Sushanth on 11/9/17.
 */

// view that handles showing the user the passowrd recovery screen and handling their input
public class PasswordRecoveryView extends AppCompatActivity {

    EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password_layout);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
    }

    public void passwordRecovery(String email, Context context){
        AccountController act = new AccountController();
        act.passwordRecovery(email, context);
    }

    public void resetPasswordButtonClicked(View view) {
        resetPassword();
    }


    public void resetPassword() {
        String email = emailEditText.getText().toString();

        // check if email is not empty.. other checks...
        if (email == null || email.isEmpty()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        // Checking that email has a @, as there needs to be at least two
        String[] emailParts = email.split("@");
        if(emailParts.length != 2){
            //the e-mail fails
            Toast.makeText(this, "Invalid email entered.", Toast.LENGTH_SHORT).show();
            return;
        }
        //check that the e-mail has the appropriate length
        if(emailParts.length == 2) {
            //getting the portion of the e-mail behind the @ sign
            String ucsdCheck = emailParts[1];
            //ucsd.edu check
            String ucsdEduCheck = "ucsd.edu";
            if(ucsdCheck.equals(ucsdEduCheck)==false) {
                Toast.makeText(this, "Enter a valid UCSD email.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        passwordRecovery(email, getApplicationContext());
    }
}
