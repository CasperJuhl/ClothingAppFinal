package com.example.clothingapp.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.clothingapp.View.AddItemFragment;
import com.example.clothingapp.View.AfterLoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DBClass {

    public static void saveToDB(String brand, String name, String website, String itemcode) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        ClothData clothData = new ClothData(brand, name, website, itemcode);
        ref.push().setValue(clothData);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ClothData data = ds.getValue(ClothData.class);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

                }
            });
    }

    public static void savetoDevice(String brand, String name, String website, String itemcode) {

    }
}
