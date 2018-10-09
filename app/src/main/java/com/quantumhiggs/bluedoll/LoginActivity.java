package com.quantumhiggs.bluedoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsr, edtPass;

//    private Vector<Users> tbUser = new Vector<>();

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsr = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user,pass;

                user = edtUsr.getText().toString();
                pass = edtPass.getText().toString();

//                for (int i=0;i<tbUser.size();i++)
//                {
                    if(Data.tbUser.get(0).getName().equals(user) && Data.tbUser.get(0).getPassword().equals(pass))
                    {
                        Intent intent = new Intent(LoginActivity.this, ViewActivity.class);
                        startActivity(intent);
//                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "LOL", Toast.LENGTH_SHORT).show();
                    }
//                }

            }
        });
    }


    public void createClick(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
