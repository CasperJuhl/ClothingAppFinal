package com.example.clothingapp.Model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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

    public void savetoDevice(String brand, String name, String website, String itemcode) {

    }
}
