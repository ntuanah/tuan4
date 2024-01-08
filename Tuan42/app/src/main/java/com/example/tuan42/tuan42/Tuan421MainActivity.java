package com.example.tuan42.tuan42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.tuan42.R;

public class Tuan421MainActivity extends AppCompatActivity {
    Button btnGetData;
    TextView tvKQ;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan421_main);
        Tuan42VolleyFn volleyFn = new Tuan42VolleyFn();
        tvKQ = findViewById(R.id.tuan421TvKQ);
        btnGetData = findViewById(R.id.tuan421Btn);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyFn.getJsonArrayOfObject(context, tvKQ);
            }
        });
    }
}