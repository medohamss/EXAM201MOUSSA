package com.example.exam201moussa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void accederer(View v ) {
        Intent i=null;
        switch (v.getId()){
            case R.id.btnAdd:
                i=new Intent(this,AddSociete.class);
                break;
            case R.id.btnEdit:
                i=new Intent(this,EditSociete.class);
                break;
            case R.id.btnAllSoc:
                i=new Intent(this,ListeSociete.class);
                break;

        }
        startActivity(i);
    }
}