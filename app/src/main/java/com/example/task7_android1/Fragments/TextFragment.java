package com.example.task7_android1.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.task7_android1.MyModel;
import com.example.task7_android1.R;

public class TextFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView txtTitle;
    private TextView txtSubtitle;

    MyModel myModel;

    public TextFragment() {
    }

    public static TextFragment newInstance(String param1, String param2) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        txtTitle = view.findViewById(R.id.txt_title);
        txtSubtitle = view.findViewById(R.id.txt_subtitle);
        return view;
    }

    public void displayDetails(MyModel model) {
        this.myModel = model;
        txtTitle.setText(myModel.getTitle());
        txtSubtitle.setText(myModel.getSubtitle());
    }
}