package com.example.clothingapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.clothingapp.Model.ClothData;
import com.example.clothingapp.Model.Parameters;
import com.example.clothingapp.R;
import com.example.clothingapp.ViewModel.ClothViewModel;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {

    ClothViewModel viewModel;
    ScrollView scrollView;
    TextView favoriteText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(ClothViewModel.class);
        scrollView = view.findViewById(R.id.scrollFavorite);
        favoriteText = view.findViewById(R.id.scrollTextview);
        ArrayList<ClothData> arrayList = viewModel.getClothArrayList();
/*        ScrollView scroll = new ScrollView(this);
        TextView tv1 = new TextView(this);
        tv1.setText("This is tv1");

        scroll.addView(tv1);

        setContentView(scroll);*/
    }
}
