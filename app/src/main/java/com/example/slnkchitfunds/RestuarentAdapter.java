package com.example.slnkchitfunds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class RestuarentAdapter  extends RecyclerView.Adapter<RestuarentAdapter.ViewHolder> {
    Context mContext;
    String[] names;
    String[] address;
    String[] rate;
    String[] bill;
    int[] images;
    public RestuarentAdapter(Context context, String[] names, String[] address, String[] rate, String[] bill, int[] images) {

        this.address=address;
        this.names=names;
        this.mContext=context;
        this.rate=rate;
        this.bill=bill;
        this.images=images;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.restuarent_adapter, parent, false);

        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return names.length;
    }


    public class ViewHolder  extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
