package com.example.clothingapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.clothingapp.Model.ClothData;
import com.example.clothingapp.Model.DBClass;
import com.example.clothingapp.Model.Model;
import com.example.clothingapp.Model.Parameters;
import com.example.clothingapp.Model.ApiRepository;

import java.util.ArrayList;

public class ClothViewModel extends ViewModel {

    private Model model;
    ApiRepository repository;
    DBClass dbClass;
    public ClothViewModel()
    {
        model = Model.getInstance();
        repository = ApiRepository.getInstance();
        dbClass = new DBClass();
    }
    public boolean login(String username, String password) {
        return model.login(username, password);
    }

    public LiveData<Parameters> getParams() {
        return repository.getParams();
    }

    public void updateView() {
        repository.updateView();
    }

    public void saveToDB(String brand, String name, String website, String itemcode) {
        dbClass.saveToDB(brand, name, website, itemcode);
    }

    public void saveLocal(String brand, String name, String website, String itemcode) {
        dbClass.savetoDevice(brand, name, website, itemcode);
    }

    public ArrayList<ClothData> getClothArrayList() {
        ArrayList<ClothData> clothArrayList = dbClass.getClothArrayList();
        return clothArrayList;
    }
}
