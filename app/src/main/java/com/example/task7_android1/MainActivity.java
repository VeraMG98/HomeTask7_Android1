package com.example.task7_android1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.task7_android1.Activity.DetailsActivity;
import com.example.task7_android1.Fragments.ChangeFragment;

public class MainActivity extends AppCompatActivity implements InterfaceMassage {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private boolean aViewFragment = false;
    public static String KEY_TITLE = "key";
    public static String KEY_SUBTITLE = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fragmentView = findViewById(R.id.fragment_first);
        if (fragmentView != null){
            aViewFragment = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (aViewFragment){
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_first, new ChangeFragment());
            transaction.commit();
        }
    }

    public void displayDetails(MyModel model) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(KEY_TITLE, model.getTitle());
        intent.putExtra(KEY_SUBTITLE, model.getSubtitle());
        startActivity(intent);
    }

    public boolean getScreenOrientation() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    @Override
    public void sendInfoTextFragment(MyModel model) {
        transaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_second);
        ((TextView) fragment.getView().findViewById(R.id.txt_title)).setText(model.getTitle());
        ((TextView) fragment.getView().findViewById(R.id.txt_subtitle)).setText(model.getSubtitle());
        transaction.commit();
    }
}