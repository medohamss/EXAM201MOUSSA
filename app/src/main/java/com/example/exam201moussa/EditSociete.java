package com.example.exam201moussa;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EditSociete extends AppCompatActivity {
    EditText e1, e2, e3;
    MyDatabase db;
    Spinner sp;
    ArrayList<Societe> soc;
    ArrayAdapter ad;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_Societe);
        db = new MyDatabase(this);
        e1 = e1.findViewById(R.id.Nom);
        e2 = e2.findViewById(R.id.Sec);
        e3 = e3.findViewById(R.id.Nbr);
        sp = sp.findViewById(R.id.sp);

        soc = db.getListeSocoete(db.getReadableDatabase());

        ArrayList<String> ids = new ArrayList<>();
        for (Societe soc : soc)
            ids.add(String.valueOf(soc.getID()));

        ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ids);
        sp.setAdapter(ad);
    }


}
