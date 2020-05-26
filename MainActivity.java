package com.example.onclickloadfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bu1,bu2;
    Fragment x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu1=(Button)findViewById(R.id.b1);
        bu2=(Button)findViewById(R.id.b2);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragone f1 = new fragone();
                fragmentTransaction.add(R.id.frag_contain,f1);
                fragmentTransaction.commit();
            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragtwo f2 = new fragtwo();
                x=fragmentManager.findFragmentById(R.id.frag_contain);
                fragmentTransaction.replace(R.id.frag_contain,f2);
                fragmentTransaction.commit();
            }
        });
    }
}
