package com.example.task7_android1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task7_android1.Fragments.ChangeFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private boolean aViewFragment = false;
    public static final String KEY_TITLE = "key1";
    public static final String KEY_SUBTITLE = "key2";
    public static final String KEY_IMAGE = "key3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fragmentView = findViewById(R.id.fragment_first);
        if (fragmentView != null){
            aViewFragment = true;
        }
        if (aViewFragment){
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_first, new ChangeFragment());
            transaction.commit();
        }
    }

    public void displayDetail(MyModel model) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra(KEY_TITLE, model.getTitle());
            intent.putExtra(KEY_SUBTITLE, model.getSubtitle());
            intent.putExtra(KEY_IMAGE,model.getPhoto());
            startActivity(intent);
        } else {
            transaction = fragmentManager.beginTransaction();
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_second);
            ((TextView) fragment.getView().findViewById(R.id.txt_title)).setText(model.getTitle());
            ((TextView) fragment.getView().findViewById(R.id.txt_subtitle)).setText(model.getSubtitle());
            ((ImageView) fragment.getView().findViewById(R.id.img_photo_text_f))
                    .setImageDrawable(ContextCompat.getDrawable(this, model.getPhoto()));
            transaction.commit();
        }
    }
}