package com.quantumhiggs.bluedoll;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class DollAdapter extends RecyclerView.Adapter<DollAdapter.CardViewViewHolder> {

    private Vector<Dolls> listDolls;
    private Context context;

    public DollAdapter(Context context) {
        this.context = context;
    }

    public Vector<Dolls> getListDolls() {
        return listDolls;
    }

    public void setListDolls(Vector<Dolls> listDolls) {
        this.listDolls = listDolls;
    }

    @NonNull
    @Override
    public DollAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_dolls, viewGroup, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DollAdapter.CardViewViewHolder cardViewViewHolder, final int i)
    {
        final Dolls doll = getListDolls().get(i);

        cardViewViewHolder.tvDollName.setText(doll.getName().toString());

        //view clicked
        cardViewViewHolder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "View in "+getListDolls().get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,DollDetailActivity.class);
                context.startActivity(intent);
                /* TODO
                * Intent ke Doll Detail Activity
                * tambahin intent put extra untuk :
                * nama
                * desc
                * gambar*/
            }
        });

        //modif clicked
        cardViewViewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "modif in "+getListDolls().get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,ModifDollActivity.class);
                context.startActivity(intent);
                /* TODO
                 * Intent ke Modif Doll Activity
                 * tambahin intent put extra untuk :
                 * nama
                 * desc
                 * gambar
                 * buat activity modif*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListDolls().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        TextView tvDollName;
        Button btnView;
        Button btnEdit;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDollName = itemView.findViewById(R.id.tvDollName);
            btnView = itemView.findViewById(R.id.btnDetails);
            btnEdit = itemView.findViewById(R.id.btnModify);

        }
    }
}
