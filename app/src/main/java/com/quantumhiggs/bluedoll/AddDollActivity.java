package com.quantumhiggs.bluedoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Vector;

public class AddDollActivity extends AppCompatActivity {

    EditText edtName,edtDesc;
    Spinner spinImage;

    Vector<Dolls> doll = new Vector<>();


    /** TODO
     * Tambahkan Gambar ke Spinner
     * Submit Gambar ke object
     * tambah String buat ID primary key
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doll);

        edtName = findViewById(R.id.edtDollName);
        edtDesc = findViewById(R.id.edtDollDesc);
        spinImage = findViewById(R.id.spinImage);

    }

    public void DollAdd(View view) {
        String id = "";
        String name = edtName.getText().toString();
        String desc = edtDesc.getText().toString();
        String image = "";

        doll.add(new Dolls(id,name,desc,image));

    }
}
