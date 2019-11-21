package com.example.clothingapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.clothingapp.Model.DBClass;
import com.example.clothingapp.Model.Model;
import com.example.clothingapp.Model.Parameters;
import com.example.clothingapp.Model.ApiRepository;

public class ClothViewModel extends ViewModel {

    private Model model;
    ApiRepository repository;

    public ClothViewModel()
    {
        model = Model.getInstance();
        repository = ApiRepository.getInstance();
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
        DBClass.saveToDB(brand, name, website, itemcode);
    }

    public void saveLocal(String brand, String name, String website, String itemcode) {
        DBClass.savetoDevice(brand, name, website, itemcode);
    }
}
