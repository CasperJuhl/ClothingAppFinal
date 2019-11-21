package com.example.clothingapp.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clothingapp.Model.Parameters;
import com.example.clothingapp.R;
import com.example.clothingapp.ViewModel.ClothViewModel;


public class KanyeFragment extends Fragment implements View.OnClickListener {

    ClothViewModel viewModel;
    TextView textView;
    Button myButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kanye, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        textView = view.findViewById(R.id.displayKanyeText);
        myButton = (Button) view.findViewById(R.id.getApiButton);
        myButton.setOnClickListener(this);
        viewModel = ViewModelProviders.of(this).get(ClothViewModel.class);
        viewModel.getParams().observe(this, new Observer<Parameters>() {
            @Override
            public void onChanged(Parameters parameters) {
                textView.setText(parameters.getResponse());
            }
        });
    }

    @Override
    public void onClick(View v) {
        viewModel.updateView();
    }
}
