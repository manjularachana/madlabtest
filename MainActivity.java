                                                                                    package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

                                                                                    public class MainActivity extends AppCompatActivity {
    TextView x;
    Fragment b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x=(TextView)findViewById(R.id.t1);

    }
}
