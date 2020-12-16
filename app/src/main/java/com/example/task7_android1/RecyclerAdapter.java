package com.example.task7_android1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private final ArrayList<MyModel> list;
    private final Context context;
    public IFragments listener;

    public RecyclerAdapter(ArrayList<MyModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.onBind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        private final TextView txtTitle;
        private final TextView txtSubtitle;
        private final ImageView imgPhoto;
        private MyModel model;
        int position = 0;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.txt_title_list);
            txtSubtitle = itemView.findViewById(R.id.txt_subtitle_list);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        private void onBind(MyModel model, int position) {
            this.model = model;
            this.position = position;
            txtTitle.setText(model.getTitle());
            txtSubtitle.setText(model.getSubtitle());
            imgPhoto.setImageDrawable(ContextCompat.getDrawable(context, model.getPhoto()));
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.displayDetail(model);
            }
        }
    }

    public void setOnClickListener(IFragments iFragments) {
        this.listener = iFragments;
    }

}

