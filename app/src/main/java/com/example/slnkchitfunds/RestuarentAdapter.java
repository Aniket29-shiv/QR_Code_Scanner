package com.example.slnkchitfunds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RestuarentAdapter  extends BaseAdapter {
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
        View view=inflater.inflate(R.layout.restuarent_adapter,parent,false);

        TextView textname=view.findViewById(R.id.name);
        TextView textViewAddress=view.findViewById(R.id.address);
        TextView textrate=view.findViewById(R.id.rate);
        TextView textBill=view.findViewById(R.id.bill);
        ImageView imageView=view.findViewById(R.id.image);

        textname.setText(names[position]);
        textViewAddress.setText(address[position]);
        textrate.setText(rate[position]);
        textBill.setText(bill[position]);
        imageView.setImageResource(images[position]);

        return view;
    }
}
