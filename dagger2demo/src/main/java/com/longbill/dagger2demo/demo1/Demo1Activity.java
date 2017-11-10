package com.longbill.dagger2demo.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.longbill.dagger2demo.R;

import java.security.PublicKey;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

public class Demo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);

        new Salad();
    }
}
