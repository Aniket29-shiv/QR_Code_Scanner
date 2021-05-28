package com.example.slnkchitfunds;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CartFragment extends Fragment implements View.OnClickListener {

    Button butProceedtoPay,butPaybyCash,butProceed;
    LinearLayout layoutMenu,layioutCart;
    TextView txtincrement,txtnumber,txtdecrement,txtincrement2,txtnumber2,txtdecrement2,txtincrement3,txtnumber3,txtdecrement3,txtincrement4,txtnumber4,txtdecrement4;
    int count=1;
    int count2=1;
    int count3=1;
    int count4=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.cart_fragment,container,false);

        butProceed=view.findViewById(R.id.but_proceed);
        layioutCart=view.findViewById(R.id.layout_cart);
        layoutMenu=view.findViewById(R.id.layout_menu);
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

        butProceed.setOnClickListener(this);

        butPaybyCash=view.findViewById(R.id.but_pay);
        butProceedtoPay=view.findViewById(R.id.but_proced);

        butProceedtoPay.setOnClickListener(this);
        butPaybyCash.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_proceed:
                layoutMenu.setVisibility(View.GONE);
                layioutCart.setVisibility(View.VISIBLE);
                break;
            case R.id.but_proced:
                Dialogbox();
                break;
            case R.id.but_pay:
                Dialogbox();
                break;
            default:
                break;
        }
    }

    private void Dialogbox() {

        final Dialog dialog = new Dialog(getContext(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.dialog);

        Button button=dialog.findViewById(R.id.but_finish);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        dialog.show();
    }
}
