package com.example.mephi;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NewsPaperFragment extends Fragment {

    ArrayList<Article> newsArrayList;
    private String[] newsHeading;
    private RecyclerView recyclerView;
    private int[] newsImageIDs;

    public static NewsPaperFragment newInstance(String param1, String param2) {
        NewsPaperFragment fragment = new NewsPaperFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_paper, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerView = view.findViewById(R.id.news_paper);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);
        NewsPaperAdapter npAdapter = new NewsPaperAdapter(getContext(), newsArrayList);
        recyclerView.setAdapter(npAdapter);
        npAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        newsArrayList = new ArrayList<>();
        newsHeading = new String[]{
                "Посвящение в студенты",
                "III Конгресс молодых ученных",
                "Объявление",
                "Sample",
                "Sample",
                "Sample",
                "Sample",
                "Sample",
                "Sample",
        };

        newsImageIDs = new int[]{
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.bolt,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.bolt,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
        };

        for (int i = 0; i < newsHeading.length; i++) {
            Article article = new Article(newsHeading[i], newsImageIDs[i]);
            newsArrayList.add(article);
        }
    }
}


