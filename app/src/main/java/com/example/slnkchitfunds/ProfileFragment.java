package com.example.slnkchitfunds;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    TextView txtEditProfile,txtLogOut;
    LinearLayout layoutUser,layoutEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.profile_fragment,container,false);

        txtEditProfile=view.findViewById(R.id.txt_edtprofile);
        txtLogOut=view.findViewById(R.id.txt_logout);
        layoutEdit=view.findViewById(R.id.layout_edt_profile);
        layoutUser=view.findViewById(R.id.layout_user_profile);

        txtEditProfile.setOnClickListener(this);
        txtLogOut.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_edtprofile:
                layoutUser.setVisibility(View.GONE);
                layoutEdit.setVisibility(View.VISIBLE);
                break;
            case R.id.txt_logout:
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Are you sure Logout")
                        .setPositiveButton("Logout", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                getActivity().finish();
                                Intent intent2=new Intent(getContext(),MainActivity.class);
                                startActivity(intent2);

                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert1 = alert.create();
                alert1.show();
                break;
            default:
                break;
        }
    }
}
