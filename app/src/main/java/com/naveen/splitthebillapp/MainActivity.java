package com.naveen.splitthebillapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the button variable
        Button splitHelpButton= (Button) findViewById(R.id.btn);
        //validate the splitHelpButton reference
        assert  splitHelpButton!=null;


        //adding the eventhandler for the button
        View.OnClickListener splitHelpButtonListner=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating the intent for the splitHelpButton
                Intent splitHelpButtonIntent=new Intent(MainActivity.this,Bill.class);
                startActivity(splitHelpButtonIntent);
            }
        };

    splitHelpButton.setOnClickListener(splitHelpButtonListner);

    }
}
