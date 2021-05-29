package com.example.slnkchitfunds;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class RestuarentFragment extends Fragment {
    int[] images={R.drawable.tabla,R.drawable.mafil,R.drawable.subhya,R.drawable.paridase,R.drawable.hotel,R.drawable.raja};
    String[] names={"Tabla Restaurant","Mehfil Restaurant","Subbya Gari Hotel","Paradise Biryani","Santosh Dhaba","Raja Rani Ruchulu"};
    String[] address={"North Indian,Chinese","Haleem,Biryani","South Indian","Haleem North Indian","Biryani,Chinese","Biryani,Indian"};
    String[] rate={"Kukatpally | 1.6 kms","Nizampet & Oragathi Nagar |1.4 kms","Kukatpally | 2.9 kms","Kukatpally |2.7 kms","Kukatpally | 2.4 Kms","Kukatpally | 2.2 kms"};
    String[] bill={"* 3.8 . 30 mins . $400 for two","* 4.8 . 20 mins . $300 for two","* 3.8 . 30 mins . $400 for two","* 3.8 . 30 mins . $400 for two","* 3.8 . 30 mins . $400 for two","* 3.8 . 30 mins . $400 for two"};
    ListView listView;
    LinearLayout layout;
    TextView txtincrement,txtnumber,txtdecrement,txtincrement2,txtnumber2,txtdecrement2,txtincrement3,txtnumber3,txtdecrement3,txtincrement4,txtnumber4,txtdecrement4;
    int count=1;
    int count2=1;
    int count3=1;
    int count4=1;
    Button butProceed;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.restuarent_fragment,container,false);

        listView=view.findViewById(R.id.item);
        layout=view.findViewById(R.id.layout_details);
        txtdecrement=view.findViewById(R.id.decrement);
        txtincrement=view.findViewById(R.id.increment);
        txtnumber=view.findViewById(R.id.number);
        txtdecrement2=view.findViewById(R.id.decrement2);
        txtincrement2=view.findViewById(R.id.increment2);
        txtnumber2=view.findViewById(R.id.number2);
        txtdecrement3=view.findViewById(R.id.decrement3);
        txtincrement3=view.findViewById(R.id.increment3);
        txtnumber3=view.findViewById(R.id.number3);
        txtdecrement4=view.findViewById(R.id.decrement4);
        txtincrement4=view.findViewById(R.id.increment4);
        txtnumber4=view.findViewById(R.id.number4);
        butProceed=view.findViewById(R.id.but_proceed);

        /*butProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
            }
        });
*/
        txtdecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                txtnumber.setText(String.valueOf(count));
            }
        });

        txtincrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtnumber.setText(String.valueOf(count));
            }
        });
        txtdecrement2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2--;
                txtnumber2.setText(String.valueOf(count2));
            }
        });

        txtincrement2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2++;
                txtnumber2.setText(String.valueOf(count2));
            }
        });
        txtdecrement3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count3--;
                txtnumber3.setText(String.valueOf(count3));
            }
        });

        txtincrement3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count3++;
                txtnumber3.setText(String.valueOf(count3));
            }
        });
        txtdecrement4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count4--;
                txtnumber4.setText(String.valueOf(count4));
            }
        });

        txtincrement4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count4++;
                txtnumber4.setText(String.valueOf(count4));
            }
        });

        RestuarentAdapter adapter=new RestuarentAdapter(getContext(),names,address,rate,bill,images);
        listView.setAdapter((ListAdapter) adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        listView.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        listView.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        listView.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        listView.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        listView.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        listView.setVisibility(View.GONE);
                        layout.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });


        return view;
    }
}
