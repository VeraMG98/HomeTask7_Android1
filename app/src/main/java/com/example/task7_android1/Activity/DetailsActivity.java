package com.example.task7_android1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.task7_android1.Fragments.TextFragment;
import com.example.task7_android1.MainActivity;
import com.example.task7_android1.MyModel;
import com.example.task7_android1.R;

public class DetailsActivity extends AppCompatActivity {
    MyModel myModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null) {
            myModel = new MyModel(intent.getStringExtra(MainActivity.KEY_TITLE),
                    intent.getStringExtra(MainActivity.KEY_SUBTITLE));
        }

        FragmentManager manager = getSupportFragmentManager();
        TextFragment fragment = (TextFragment) manager.findFragmentById(R.id.fragment_text);
        FragmentTransaction transaction = manager.beginTransaction();
        fragment.displayDetails(myModel);
        transaction.commit();
    }
}