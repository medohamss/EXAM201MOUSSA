package com.example.exam201moussa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MyDatabase {
    public static String DB_NAME = "societes.db";
    public static String TABLE_NAME = "societe";
    public static String COL1 = "ID";
    public static String COL2 = "Raison_Sociale";
    public static String COL3 = "Secteur_activite";
    public static String COL4 = "nb_employe";

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + " ("+ COL1 +" integer primary key autoincrement, "+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" integer )";
        sqLiteDatabase.execSQL(sql);
    }


    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long AddSociete(SQLiteDatabase db, Societe e){
        ContentValues content = new ContentValues();
        content.put(COL2, e.getNbEmployee());
        content.put(COL3, e.getSecteur());
        content.put(COL4, e.getNbEmployee());
        return db.insert(TABLE_NAME,null,content);
    }
    public static long UpdateSociete(SQLiteDatabase db, Societe e){
        ContentValues content = new ContentValues();
        content.put(COL2, e.getNbEmployee());
        content.put(COL3, e.getSecteur());
        content.put(COL4, e.getNbEmployee());
        return db.update(TABLE_NAME,content,"ID =" + e.getID(),null);
    }

    public static long DeleteSociete(SQLiteDatabase db, int id) {
        return db.delete(TABLE_NAME,"ID =" + id,null);
    }



    public static ArrayList<Societe> getListeSocoete(SQLiteDatabase sqLiteDatabase){
        ArrayList<Societe> prdts = new ArrayList<>();

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        while(cur.moveToNext()){
            Societe e = new Societe();

            e.setID(cur.getInt(0));
            e.setNom(cur.getString(1));
            e.setSecteur(cur.getString(2));
            e.setNbEmployee(cur.getInt(3));
            prdts.add(e);
        }
        return prdts;
    }

    public static Societe getSociete(SQLiteDatabase sqLiteDatabase, int id){
        Societe soc = null;

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE IDPRODUIT = " + id,null);

        if(cur.moveToNext()){
            soc.setID(cur.getInt(0));
            soc.setNom(cur.getString(1));
            soc.setSecteur(cur.getString(2));
            soc.setNbEmployee(cur.getInt(3));
        }
        return soc;
    }

}
