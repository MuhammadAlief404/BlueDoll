package com.quantumhiggs.bluedoll;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Vector;

public class ViewActivity extends AppCompatActivity {

    RecyclerView rvDoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        rvDoll = findViewById(R.id.rv_doll);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this, AddDollActivity.class);
                startActivity(intent);
            }
        });

        showDolls();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
         menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_store:
                Intent intent = new Intent(ViewActivity.this,StoreActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_logout:
                Intent intent1 = new Intent(ViewActivity.this,StoreActivity.class);
                startActivity(intent1);
                finish();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    //nampil card
    private void showDolls(){
        rvDoll.setLayoutManager(new LinearLayoutManager(this));
        DollAdapter cardViewPresidentAdapter = new DollAdapter(this);
        cardViewPresidentAdapter.setListDolls(Data.tbDoll);
        rvDoll.setAdapter(cardViewPresidentAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showDolls();
    }
}
