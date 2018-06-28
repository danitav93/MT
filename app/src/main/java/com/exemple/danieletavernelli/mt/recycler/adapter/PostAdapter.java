package com.exemple.danieletavernelli.mt.recycler.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danieletavernelli.mt.R;

import java.util.ArrayList;

/**
 * Created by Daniele Tavernelli on 6/26/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<String> listTitle;
    private Context context;

    public PostAdapter(Context context, ArrayList<String> listTitle) {
        this.listTitle = listTitle;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.titleTxtViw.setText(listTitle.get(position));

    }

    @Override
    public int getItemCount() {
        return listTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTxtViw;

        public ViewHolder(View view) {

            super(view);

            titleTxtViw = view.findViewById(R.id.post_titolo_txt_viw);

        }
    }
}
