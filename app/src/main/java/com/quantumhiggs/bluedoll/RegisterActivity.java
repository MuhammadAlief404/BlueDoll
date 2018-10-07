package com.quantumhiggs.bluedoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtEmail,edtName,edtPass,edtcPass;
    private Boolean isValid = false;
    private CheckBox chkAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.edtEmail);
        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);
        edtcPass = findViewById(R.id.edtcPass);

        chkAgree = findViewById(R.id.chkAgree);

    }

    public void registerClick(View view)
    {
        String mail,name,pass,cPass;

        mail = edtEmail.getText().toString();
        name = edtName.getText().toString();
        pass = edtPass.getText().toString();
        cPass = edtcPass.getText().toString();


        if(validatePassword(pass,6) == true)
        {
                Toast.makeText(this, "Berhasil Bege", Toast.LENGTH_SHORT).show();
        }
    }

    boolean validatePassword(String password, int n) {
        if (password == null || password.length() < n) {
            return false;
        }
        boolean upper = false;
        boolean digit = false;

        for (int i=0;i<password.length();i++) {
            if (Character.isUpperCase(i)) {
                upper = true;
            } else if (Character.isDigit(i)) {
                digit = true;
            }
            if (upper && digit) {
                return true;
            }
        }
        return false;
    }
}
