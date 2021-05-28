package com.example.slnkchitfunds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class DetailsActivity extends AppCompatActivity {
    ListView listView;
    ImageView imageView;

    String[] names={"Chicken Biryani Full","Mutton Biryani Full","Special Chicken Biryani","Special Mutton Biryani"};
    String[] rate={"$190","$220","$270","$290"};
    String[] add={"A delightful preparation","Serves with Mirchi","Regular Chicken Biryani","Regular Mutton Biryani"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listView=findViewById(R.id.list);
        imageView=findViewById(R.id.image_back);

        DetailsAdapter adapter=new DetailsAdapter(this,names,rate,add);
        listView.setAdapter(adapter);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}