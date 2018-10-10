package com.quantumhiggs.bluedoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DollDetailActivity extends AppCompatActivity {

    TextView tvName,tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doll_detail);

        tvName = findViewById(R.id.tvDNameDetail);
        tvDesc = findViewById(R.id.tvDDescDetail);

        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if(extras != null)
            {
                tvName.setText(extras.getString("name"));
                tvDesc.setText(extras.getString("desc"));
            }
        }
    }
}
