package com.longbill.dagger2demo.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.longbill.dagger2demo.R;

public class Demo3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);

        new Salad();
    }
}
