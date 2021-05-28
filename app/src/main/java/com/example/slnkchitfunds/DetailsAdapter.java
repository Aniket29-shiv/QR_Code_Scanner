package com.example.slnkchitfunds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsAdapter extends BaseAdapter {
    String[] names;
    String[] rate;
    String[] add;
    Context mContext;
    int count=1;
    public DetailsAdapter(DetailsActivity detailsActivity, String[] names, String[] rate, String[] add) {
        this.mContext=detailsActivity;
        this.names=names;
        this.rate=rate;
        this.add=add;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.details_adapter,parent,false);
        TextView textView=view.findViewById(R.id.name);
        TextView textView1=view.findViewById(R.id.address);
        TextView textView2=view.findViewById(R.id.rate);
        Button button=view.findViewById(R.id.but_add);
        LinearLayout layout=view.findViewById(R.id.layout_increment);
        TextView textincrement=view.findViewById(R.id.increment4);
        TextView textDecrement=view.findViewById(R.id.decrement4);
        TextView txtnumber=view.findViewById(R.id.number4);



        textView.setText(names[position]);
        textView1.setText(rate[position]);
        textView2.setText(add[position]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button.setVisibility(View.GONE);
                layout.setVisibility(View.VISIBLE);

            }
        });
        textDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                txtnumber.setText(String.valueOf(count));
            }
        });

        textincrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtnumber.setText(String.valueOf(count));
            }
        });
        return view;
    }
}
