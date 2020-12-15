package com.example.task7_android1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task7_android1.InterfaceMassage;
import com.example.task7_android1.MainActivity;
import com.example.task7_android1.MyModel;
import com.example.task7_android1.R;
import com.example.task7_android1.RecyclerAdapter;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements RecyclerAdapter.IFragments {
    private RecyclerView recyclerView;

    InterfaceMassage listener;
    MyModel myModel1;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (InterfaceMassage) context;
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
        View view = inflater.inflate(R.layout.fragment_change,
                container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {
        ArrayList<MyModel> list = new ArrayList<>();
        list.add(new MyModel("Title", "Subtitle"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter adapter = new RecyclerAdapter(list, getContext());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetail(MyModel myModel) {
        this.myModel1 = myModel;
        MainActivity activity = (MainActivity) getActivity();
        if (!activity.getScreenOrientation()) {
            listener.sendInfoTextFragment(myModel1);
        } else {
            activity.displayDetails(myModel1);
        }
    }
}