package com.quantumhiggs.bluedoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

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
        String id,mail,name,pass,cPass;

        id = "USR001";
        mail = edtEmail.getText().toString();
        name = edtName.getText().toString();
        pass = edtPass.getText().toString();
        cPass = edtcPass.getText().toString();


        if(mail.isEmpty() == false && name.isEmpty() == false && pass.isEmpty() == false && cPass.isEmpty() == false == chkAgree.isChecked())
        {
            if (pass.equals(cPass))
            {
                for(int i=0;i<Data.tbUser.size();i++)
                {
                    if(Data.tbUser.get(i).getEmail().equals(mail))
                    {
                        Toast.makeText(this, "Email already registered", Toast.LENGTH_SHORT).show();
                    }
                }
                Data.tbUser.add(new Users(id,mail,name,pass));
                Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
//                finish();
            }
        }
        Toast.makeText(this, "user size "+Data.tbUser.size(), Toast.LENGTH_SHORT).show();
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
