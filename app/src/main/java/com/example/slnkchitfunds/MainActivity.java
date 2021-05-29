package com.example.slnkchitfunds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;

    private RecyclerView mRVResto;

    private RestuarentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncFetch().execute();
        loadFragment(new QRScannerFragment());

        RecyclerView mRVResto = findViewById(R.id.recyclerview);

        int[] images={R.drawable.tabla,R.drawable.mafil,R.drawable.subhya,R.drawable.paridase,R.drawable.hotel,R.drawable.raja};
        String[] names={"Tabla Restaurant","Mehfil Restaurant","Subbya Gari Hotel","Paradise Biryani","Santosh Dhaba","Raja Rani Ruchulu"};
        String[] address={"North Indian,Chinese","Haleem,Biryani","South Indian","Haleem North Indian","Biryani,Chinese","Biryani,Indian"};
        String[] rate={"Kukatpally | 1.6 kms","Nizampet & Oragathi Nagar |1.4 kms","Kukatpally | 2.9 kms","Kukatpally |2.7 kms","Kukatpally | 2.4 Kms","Kukatpally | 2.2 kms"};
        String[] bill={"* 3.8 . 30 mins . $400 for two","* 4.8 . 20 mins . $300 for two","* 3.8 . 30 mins . $400 for two","* 3.8 . 30 mins . $400 for two","* 3.8 . 30 mins . $400 for two","* 3.8 . 30 mins . $400 for two"};

        RestuarentAdapter restuarentAdapter = new RestuarentAdapter(MainActivity.this, names, address, rate, bill, images);
        mRVResto.setAdapter(restuarentAdapter);
        mRVResto.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setVisibility(View.GONE);
    }

    private class AsyncFetch extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();



        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your json file resides

                url = new URL("https://qr.orsoot.com/api/web/store/fetchAll");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }


        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);

        switch (item.getItemId()) {
//            case R.id.profile:
//                fragment = new ProfileFragment();
//                break;
//            case R.id. restuarent:
//                fragment=new RestuarentFragment();
//                break;

            case R.id.scan:
                fragment = new QRScannerFragment();
                navigation.setVisibility(View.GONE);
                break;

//            case R.id.cart:
//                fragment = new CartFragment();
//                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }}