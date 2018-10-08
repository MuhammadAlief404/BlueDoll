package com.quantumhiggs.bluedoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Vector;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView rvDoll;

    private Vector<Dolls> list = new Vector<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        rvDoll = findViewById(R.id.rv_doll);

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
                return true;
            case R.id.menu_logout:
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    //nampil card
    private void showDolls(){
        rvDoll.setLayoutManager(new LinearLayoutManager(this));
        DollAdapter cardViewPresidentAdapter = new DollAdapter(this);
        cardViewPresidentAdapter.setListDolls(list);
        rvDoll.setAdapter(cardViewPresidentAdapter);
    }
}
