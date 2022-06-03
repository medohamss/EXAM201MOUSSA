package com.example.exam201moussa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddSociete extends AppCompatActivity {

    EditText e1,e2,e3;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_Societe);
        db = new MyDatabase(this);
        e1 = findViewById(R.id.Nom);
        e2 = findViewById(R.id.Sec);
        e3 = findViewById(R.id.Nbr);
        }
     public void annuler(View view){
            Intent i=new Intent(AddSociete.this, MainActivity.class);
            startActivity(i);}
    public void enregister(View view){
        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "Text vide", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
            return;
        }
        if(e2.getText().toString().isEmpty()){
            Toast.makeText(this, "Text vide", Toast.LENGTH_SHORT).show();
            e2.requestFocus();
            return;
        }
        if(e3.getText().toString().isEmpty()){
            Toast.makeText(this, "Text vide", Toast.LENGTH_SHORT).show();
            e3.requestFocus();
            return;
        }

        Societe s = new Societe();

        s.setNom(e1.getText().toString());
        s.setSecteur(e2.getText().toString());
        s.setNbEmployee(Integer.parseInt(e3.getText().toString()));

        if(db.AddSociete(db.getWritableDatabase,s)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();
    }
}