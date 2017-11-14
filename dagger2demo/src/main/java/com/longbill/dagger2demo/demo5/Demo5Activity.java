package com.longbill.dagger2demo.demo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.longbill.dagger2demo.R;

import javax.inject.Inject;

public class Demo5Activity extends AppCompatActivity {

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5);

        DaggerUserComponent.builder().build().inject(this);
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
    }
}
