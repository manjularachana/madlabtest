package com.example.pg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec extends AppCompatActivity {
    EditText t1,t2,t3;
    Button write,read;
    String name,reg,dept;
    private String filename = "SampleFile.txt";
    private String filepath = "/sdcard/SampleFile.txt";
    File myFile;
    CheckBox y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        t1= (EditText) findViewById(R.id.textView1);
        t2= (EditText) findViewById(R.id.textView2);
        t3= (EditText) findViewById(R.id.textView3);
        y=(CheckBox)findViewById(R.id.checkBox);
        //Getting the Intent
        Intent i = getIntent();

        //Getting the Values from First Activity using the Intent received
        name=i.getStringExtra("name");
        reg=i.getStringExtra("usn");
        dept=i.getStringExtra("email");

        //Setting the Values to Intent
        t1.setText(name);
        t2.setText(reg);
        t3.setText(dept);

        write=(Button)findViewById(R.id.button);
        read=(Button)findViewById(R.id.button2);
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly() ) {
            write.setEnabled(false);
            read.setEnabled(false);


        }else{
            y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if ( isChecked )
                    {
                        write.setEnabled(true);
                        read.setEnabled(true);

                    }else{
                        write.setEnabled(false);
                        read.setEnabled(false);
                    }

                }
            });
            myFile = new File(getExternalFilesDir(filepath), filename);

        }
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "name:"+name+"usn:"+reg+"email:"+dept;
                try{
                    FileOutputStream fo = new FileOutputStream(myFile,true);
                    fo.write(msg.getBytes());
                    fo.close();
                    Toast.makeText(getBaseContext(), "Data wrote to SD Card", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        read.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String message;
                String buf = "";
                try {
                    FileInputStream fin = new FileInputStream(myFile);
                    DataInputStream in = new DataInputStream(fin);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    while((message = br.readLine()) != null) {
                        buf += message;
                    }
                    Toast.makeText(getBaseContext(), "Data wrote to SD Card"+buf, Toast.LENGTH_LONG).show();

                    br.close();
                    fin.close();
                    Toast.makeText(getBaseContext(),"Data Recived from SDCARD",Toast.LENGTH_LONG).show();
                } catch(Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private static boolean isExternalStorageReadOnly(){
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable(){
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
