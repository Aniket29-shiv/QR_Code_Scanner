package com.example.slnkchitfunds;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.Result;

import org.jetbrains.annotations.NotNull;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;

public class QRScannerFragment extends Fragment  {
    private CodeScanner mCodeScanner;
    ImageView imageView;
    View line_sep;
    WebView webView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qr_fragment, container, false);

        CodeScannerView scannerView = view.findViewById(R.id.scanner_view);





        webView = view.findViewById(R.id.webView);
        webView.setVisibility(View.GONE);

        line_sep = view.findViewById(R.id.line_sep);
        line_sep.setVisibility(View.GONE);


        imageView = view.findViewById(R.id.qr_scanner);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setVisibility(View.GONE);
                scannerView.setVisibility(View.VISIBLE);
            }
        });
        mCodeScanner = new CodeScanner(getContext(), scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            line_sep.setVisibility(View.VISIBLE);
                            webView.setVisibility(View.VISIBLE);
                            webView.getSettings().setJavaScriptEnabled(true);
                            webView.loadUrl(result.getText());
                            webView.setHorizontalScrollBarEnabled(false);




//                        Toast.makeText(getContext(), result.getText(), Toast.LENGTH_SHORT).show();
                        System.out.println("This is result " + result.getText());
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }


}