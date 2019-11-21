package com.example.clothingapp.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clothingapp.Model.Cloth;
import com.example.clothingapp.Model.ClothAdapter;
import com.example.clothingapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MyListFragment extends Fragment implements ClothAdapter.OnListItemClickListener {

    RecyclerView mClothList;
    RecyclerView.Adapter mClothAdapter;
    FloatingActionButton myFab;
    ArrayList<Cloth> clothitems;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_list, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mClothList = view.findViewById(R.id.rv);
        mClothList.hasFixedSize();
        mClothList.setLayoutManager(new LinearLayoutManager(getContext()));

        clothitems = new ArrayList<>();
        clothitems.add(new Cloth("Zalando", "https://www.zalando.dk/", R.drawable.zalando));
        clothitems.add(new Cloth("Asos", "https://www.asos.com/", R.drawable.asos));
        clothitems.add(new Cloth("Wagner", "https://www.wagner.dk/", R.drawable.wagner));
        clothitems.add(new Cloth("Stylepit", "https://www.stylepit.dk/", R.drawable.stylepit));
        clothitems.add(new Cloth("Ellos", "https://www.ellos.dk/", R.drawable.ellos));
        clothitems.add(new Cloth("Jack&Jones", "https://www.jackjones.com/dk/da/home", R.drawable.jack));
        clothitems.add(new Cloth("Boozt", "https://www.boozt.com/dk/da", R.drawable.boozt));
        clothitems.add(new Cloth("H&M", "https://www2.hm.com/da_dk/dame.html", R.drawable.hogm));
        clothitems.add(new Cloth("Quint", "https://www.quint.dk/", R.drawable.quint));

        mClothAdapter = new ClothAdapter(clothitems, this);
        mClothList.setAdapter(mClothAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex, ArrayList<Cloth> clothArrayList) {
        int clothnumber = clickedItemIndex + 1;
        String website = clothArrayList.get(clothnumber-1).getSite(); //-1 because of array counting style
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra("url", website);
        startActivity(intent);
    }


}
