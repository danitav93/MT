package com.exemple.danieletavernelli.mt.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.danieletavernelli.mt.R;
import com.exemple.danieletavernelli.mt.recycler.adapter.PostAdapter;

import java.util.ArrayList;


/**
 * Created by Daniele Tavernelli on 6/26/2018.
 */

public class NewsFragment extends Fragment {

    //view
    private View entireLayout;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        entireLayout = inflater.inflate(R.layout.fragment_news, container, false);

        initViews();

        return entireLayout;




    }

    private void initViews() {
        recyclerView = entireLayout.findViewById(R.id.fragment_news_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("pino");
        strings.add("insegno");
        strings.add("fa");
        strings.add("la");
        strings.add("cacca");
        PostAdapter adapter = new PostAdapter(getContext(),strings);
        recyclerView.setAdapter(adapter);
    }


}
