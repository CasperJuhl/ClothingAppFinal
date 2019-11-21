package com.example.clothingapp.View;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clothingapp.R;
import com.example.clothingapp.ViewModel.ClothViewModel;


public class AddItemFragment extends Fragment implements View.OnClickListener {

    Button addItemButton;
    EditText brandText;
    EditText nameText;
    EditText websiteText;
    EditText itemID;
    ClothViewModel clothViewModel;
    Switch aSwitch;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_item, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        addItemButton = (Button) view.findViewById(R.id.addItemButton);
        aSwitch = view.findViewById(R.id.saveType);
        brandText = (EditText) view.findViewById(R.id.itemBrandEdit);
        nameText = (EditText) view.findViewById(R.id.itemNameEdit);
        websiteText = (EditText) view.findViewById(R.id.websiteEdit);
        itemID = (EditText) view.findViewById(R.id.itemCode);
        addItemButton.setOnClickListener(this);
        clothViewModel = ViewModelProviders.of(this).get(ClothViewModel.class);
    }


    @Override
    public void onClick(View v) {
        if(aSwitch.isChecked())
        {
            saveLocal(brandText.getText().toString(), nameText.getText().toString(), websiteText.getText().toString(), itemID.getText().toString());
            Toast toast = Toast.makeText(getContext(),"I am saving locally...", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            saveCloud(brandText.getText().toString(), nameText.getText().toString(), websiteText.getText().toString(), itemID.getText().toString());
        }

    }

    private void saveLocal(String brand, String name, String website, String itemcode) {
        if(brandText.getText() != null && nameText.getText() != null && websiteText.getText() != null) {
            clothViewModel.saveLocal(brand, name, website, itemcode);
        }
        else
        {
            Toast toast = Toast.makeText(getContext(), "Error! Input values!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void saveCloud(String brand, String name, String website, String itemcode)
 {
     if(brand.equals("") || name.equals("")) {
         Toast toast = Toast.makeText(getContext(), "Error! Input values!", Toast.LENGTH_SHORT);
         toast.show();
     }
     else
     {
         readWrite(brand, name, website, itemcode);
         Toast toast = Toast.makeText(getContext(), brandText.getText().toString() + " " + nameText.getText().toString() + " saved!", Toast.LENGTH_SHORT);
         View view = toast.getView();

         //Toast from StackOverflow example to create a custom look for a Toast
         view.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
         TextView text = view.findViewById(android.R.id.message);
         text.setTextColor(Color.WHITE);
         //I found that 250 is the yOffset which positions the Toast just above the NaviBar
         toast.setGravity(Gravity.BOTTOM, 0, 250);
         toast.show();
         brandText.setText("");
         nameText.setText("");
         websiteText.setText("");
         itemID.setText("");
     }
 }

    public void readWrite(String brand, String name, String website, String itemcode)
    {
        clothViewModel.saveToDB(brand, name, website, itemcode);
    }
}

