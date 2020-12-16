package com.example.task7_android1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.task7_android1.Fragments.TextFragment;
import com.example.task7_android1.MainActivity;
import com.example.task7_android1.MyModel;
import com.example.task7_android1.R;

public class DetailsActivity extends AppCompatActivity {
    String title;
    String subtitle;
    int photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(MainActivity.KEY_TITLE);
            subtitle = intent.getStringExtra(MainActivity.KEY_SUBTITLE);
            photo = intent.getIntExtra(MainActivity.KEY_IMAGE, 0);
        }

        FragmentManager manager = getSupportFragmentManager();
        TextFragment fragment = (TextFragment) manager.findFragmentById(R.id.fragment_text);
        FragmentTransaction transaction = manager.beginTransaction();
        fragment.displayDetails(new MyModel(title, subtitle, photo));
        transaction.commit();
    }
}