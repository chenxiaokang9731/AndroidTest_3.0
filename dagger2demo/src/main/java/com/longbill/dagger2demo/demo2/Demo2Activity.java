package com.longbill.dagger2demo.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.longbill.dagger2demo.R;

public class Demo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        new Salad();
    }
}
