package com.example.clothingapp.View;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.clothingapp.Model.Cloth;
import com.example.clothingapp.Model.ClothData;
import com.example.clothingapp.Model.Parameters;
import com.example.clothingapp.R;
import com.example.clothingapp.ViewModel.ClothViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {

    ClothViewModel viewModel;
    ScrollView scrollView;
    ScrollView scroll;
    LinearLayout linearLayoutScroll;
    TextView scrollTV;
    ArrayList<ClothData> arrayList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        viewModel = new ClothViewModel();
        scrollView = view.findViewById(R.id.scrollView);
        scroll = new ScrollView(getContext());
        scrollTV = new TextView(getContext());
        linearLayoutScroll = view.findViewById(R.id.linearLayoutScroll);
        arrayList = new ArrayList<ClothData>();
        populateView();
    }


    public void populateView()
    {
        arrayList = viewModel.getClothArrayList();
        if(arrayList!=null) {
            linearLayoutScroll.removeAllViews();
            for (int i = 0; i < arrayList.size(); i++) {
                TextView favorites = new TextView(getContext());
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                favorites.setText("Brand: " + arrayList.get(i).getBrand() + "\n Name: " + arrayList.get(i).getName() + "\n Website: "
                        + arrayList.get(i).getSite() + "\n Itemnumber: " + arrayList.get(i).getItemcode());
                favorites.setTextColor(Color.BLACK);
                favorites.setTextAppearance(R.style.ClothStyleScroll);
                favorites.setLayoutParams(lp);
                favorites.setGravity(Gravity.CENTER);
                favorites.setPadding(0, 0, 0, 100);
                favorites.setElegantTextHeight(true);
                favorites.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                favorites.setSingleLine(false);
                linearLayoutScroll.addView(favorites);
            }
        }
        else {
                //Error
        }
    }
}
