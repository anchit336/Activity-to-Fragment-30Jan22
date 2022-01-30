package com.example.activitytofragment30jan22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.activitytofragment30jan22.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MyFirstFragment myFirstFragment = new MyFirstFragment();

        binding.buttonCalculate.setOnClickListener(view -> {

            Bundle bundle = new Bundle(); // Bundle use for data Transformation

            int userWeight = Integer.valueOf(binding.editTextWeight.getText().toString());
            int userHeight = Integer.valueOf(binding.editTextHeight.getText().toString());

            bundle.putInt("weight", userWeight);
            bundle.putInt("height", userHeight);

            myFirstFragment.setArguments(bundle);

            fragmentTransaction.add(R.id.frame, myFirstFragment);

            fragmentTransaction.commit();
        });
    }
}