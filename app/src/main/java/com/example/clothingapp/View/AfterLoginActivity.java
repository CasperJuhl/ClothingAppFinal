package com.example.clothingapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.clothingapp.R;
import com.example.clothingapp.ViewModel.ClothViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AfterLoginActivity extends AppCompatActivity {

    ClothViewModel viewModel;
    FavoriteFragment favFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        getSupportActionBar().hide();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentHolder, new MyListFragment());
        transaction.addToBackStack(null);
        transaction.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId())
                {
                    case R.id.myList:
                        transaction.replace(R.id.fragmentHolder, new MyListFragment());
                        break;
                    case R.id.favorites:
                        transaction.replace(R.id.fragmentHolder, new FavoriteFragment());
                        break;
                    case R.id.addlist:
                        transaction.replace(R.id.fragmentHolder, new AddItemFragment());

                        break;
                    case R.id.Kanye:
                        transaction.replace(R.id.fragmentHolder, new KanyeFragment());
                        break;
                }
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            }
        });
    }
    public void updateView(View view) {
        viewModel.updateView();
    }

}
