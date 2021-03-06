package com.quantumhiggs.bluedoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class RegisterActivity extends AppCompatActivity {

    private static Set<Character> bad = new HashSet<>();

    private EditText edtEmail,edtName,edtPass,edtcPass;
    private Boolean isValid = false;
    private Boolean digitSemua = false;
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

    public static boolean check(String email) {
        String name = email.substring(0, email.indexOf('@'));
        String domain = email.substring(email.indexOf('@')+1, email.length());
//    String[] split = email.split("@");
        return checkAgain(name) && checkAgain(domain);
    }

    public static boolean checkAgain(String part) {
        if (bad.contains(part.charAt(0))) return false;
        if (bad.contains(part.charAt(part.length()-1))) return false;
        return true;
    }

    public void registerClick(View view)
    {
        int id;
        int digit =0;
        String mail;
        String name;
        String pass;
        String cPass;

        id = Data.tbUser.size() + 1;
        mail = edtEmail.getText().toString();
        name = edtName.getText().toString();
        pass = edtPass.getText().toString();
        cPass = edtcPass.getText().toString();

        char[] specialChars = new char[] {'!', '#', '$', '%', '^', '&', '*', '(', ')', '-', '/', '~', '[', ']'} ;
        for (char c : specialChars) {
            bad.add(c);
        }

        if(mail.isEmpty() == true)
        {
            Toast.makeText(this, "Please Insert Email", Toast.LENGTH_SHORT).show();
        }
        if(name.isEmpty() == true)
        {
            Toast.makeText(this, "Please Insert Name", Toast.LENGTH_SHORT).show();
        }
        if(pass.isEmpty() == true)
        {
            Toast.makeText(this, "Please Insert Password", Toast.LENGTH_SHORT).show();
        }


        if(mail.isEmpty() == false && name.isEmpty() == false && pass.isEmpty() == false && cPass.isEmpty() == false == chkAgree.isChecked())
        {
            if (pass.equals(cPass) && pass.length() >= 6)
            {
                for(int z=0;z<pass.length();z++)
                {
                    if(Character.isDigit(pass.charAt(z)) == true)
                    {
                        digit++;
                        if(pass.length() == digit)
                        {
                            digitSemua = true;
                        }
                        isValid = true;
                    }
                }
                for(int i=0;i<Data.tbUser.size();i++) {
                    if (Data.tbUser.get(i).getEmail().equals(mail)) {
                        Toast.makeText(this, "Email already registered", Toast.LENGTH_SHORT).show();
                        isValid = false;
                    }
                }
            }
        }
        if(isValid == true && check(mail) == true && digitSemua == false)
        {
//                    Toast.makeText(this, " "+digit + "size " +pass.length(), Toast.LENGTH_SHORT).show();
            Data.tbUser.add(new Users(id,mail,name,pass));
            Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
            //reset bool
        else if(isValid == false)
        {
            ResetData();
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }
        else if (check(mail) == false)
        {
            ResetData();
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show();
        }
        else if(digitSemua == true || pass.length() < 6 || !pass.equals(cPass))
        {
            ResetData();
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
        }
    }

    public void ResetData()
    {
        isValid = false;
        digitSemua = false;
        edtEmail.setText("");
        edtName.setText("");
        edtPass.setText("");
        edtcPass.setText("");
        chkAgree.setChecked(false);
    }
}
