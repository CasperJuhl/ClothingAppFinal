package com.example.clothingapp.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class DBClass {

    private static ArrayList<ClothData> clothArrayList;

    public void saveToDB(String brand, String name, String website, String itemcode) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        //clothArrayList = new ArrayList<ClothData>();
        ClothData clothData = new ClothData(brand, name, website, itemcode);
        ref.push().setValue(clothData);
        //ref.child("Items").push().setValue(clothData);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                clothArrayList = new ArrayList<ClothData>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ClothData data = ds.getValue(ClothData.class);
                    clothArrayList.add(data);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

                }
            });
    }

    public ArrayList<ClothData> getClothArrayList() {
        return clothArrayList;
    }

    public String[] savetoDevice(String brand, String name, String website, String itemcode, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("brand", brand);
        editor.putString("name", name);
        editor.putString("website", website);
        editor.putString("itemcode", itemcode);

        String[] dataName = new String[4];
        dataName[0] = prefs.getString("brand", "default_name");
        dataName[1] = prefs.getString("name", "default_name");
        dataName[2] = prefs.getString("website", "default_name");
        dataName[3] = prefs.getString("itemcode", "default_name");
        editor.apply();
        return dataName;
    }
}
