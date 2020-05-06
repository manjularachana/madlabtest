package com.example.pg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button bt;


    //Data for populating in Spinner


    String name,reg,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        bt= (Button) findViewById(R.id.button);



        //Creating Adapter for Spinner for adapting the data from array to Spinner


        //Creating Listener for Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {

                //Getting the Values from Views(Edittext & Spinner)
                name=e1.getText().toString();
                reg=e2.getText().toString();
                email=e3.getText().toString();

                //Intent For Navigating to Second Activity
                Intent i = new Intent(MainActivity.this,sec.class);

                //For Passing the Values to Second Activity
                i.putExtra("name", name);
                i.putExtra("usn",reg);
                i.putExtra("email",email);

                startActivity(i);

            }
        });

    }
}
