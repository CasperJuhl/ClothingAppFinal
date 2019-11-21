package com.example.clothingapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.clothingapp.Model.Cloth;
import com.example.clothingapp.R;
import com.example.clothingapp.ViewModel.ClothViewModel;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ClothViewModel clothViewModel;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private static final int RC_SIGN_IN = 42;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        clothViewModel = ViewModelProviders.of(this).get(ClothViewModel.class);
        usernameEdit = findViewById(R.id.userIdEditText);
        passwordEdit = findViewById(R.id.passwordEditText);
        progressBar = findViewById(R.id.loginProgress);
        progressBar.setVisibility(View.INVISIBLE);
    }
    public void signIn(View v) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.logo)
                .build();

        startActivityForResult(signInIntent, RC_SIGN_IN);
        checkIfSignedIn();
    }

    private void checkIfSignedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Toast.makeText(getApplicationContext(), "User info confirmed from previous login!", Toast.LENGTH_SHORT).show();
            goToMainActivity();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No active users, please continue", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToMainActivity() {
        startActivity(new Intent(this, AfterLoginActivity.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInRequest(resultCode);
        }
    }

    private void handleSignInRequest(int resultCode) {
        if (resultCode == RESULT_OK)
            goToMainActivity();
        else
            Toast.makeText(this, "SIGN IN CANCELLED", Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        progressBar.setVisibility(View.VISIBLE);
        String username = usernameEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        boolean login = clothViewModel.login(username, password);
        if(login)
        {
            Intent intent = new Intent(MainActivity.this, AfterLoginActivity.class);
            startActivity(intent);
        }
        else
        {
            Context context = getApplicationContext();
            String text = "Login failed, incorrect credentials!";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
