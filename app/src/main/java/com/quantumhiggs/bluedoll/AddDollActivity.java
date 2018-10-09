package com.quantumhiggs.bluedoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Vector;

public class AddDollActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText edtName,edtDesc;
    Spinner spinImage;
    Button btnSubmit;

    Vector<Dolls> doll = new Vector<>();

    private static final Integer[] dollImage = {R.drawable.doll1, R.drawable.doll2, R.drawable.doll3,
            R.drawable.doll4, R.drawable.doll5, R.drawable.doll6,
            R.drawable.doll7};


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
        btnSubmit = findViewById(R.id.btnDollSubmit);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinImage);
        mySpinner.setAdapter(new MySpinnerAdapter());
        mySpinner.setOnItemSelectedListener(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = "";
                String name = edtName.getText().toString();
                String desc = edtDesc.getText().toString();
                String image = "";

                doll.add(new Dolls(id,name,desc,image));
                Toast.makeText(getApplicationContext(), "Size " + doll.size(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ViewActivity.class);
                startActivity(intent);

            }
        });

    }



    //--------------------------------------------------------------------------------------

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Selected: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private static class ViewHolder {
        ImageView imageView;
    }

    private class MySpinnerAdapter extends BaseAdapter {

        public int getCount() {
            return dollImage.length;
        }

        @Override
        public Integer getItem(int position) {
            return dollImage[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            ViewHolder dollViewHolder;
            if (convertView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_spinner_doll, parent, false);

                dollViewHolder = new ViewHolder();
                dollViewHolder.imageView = (ImageView) itemView.findViewById(R.id.imgDolls);
                itemView.setTag(dollViewHolder);

            }
            else {
                dollViewHolder = (ViewHolder) itemView.getTag();
            }

            dollViewHolder.imageView.setImageDrawable(getResources().getDrawable(dollImage[position]));

            return itemView;
        }
    }
}
