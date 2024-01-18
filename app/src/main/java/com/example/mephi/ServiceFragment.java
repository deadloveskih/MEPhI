package com.example.mephi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class ServiceFragment extends Fragment {
    ArrayList<Service> ServicesPacks;

    public static ServiceFragment newInstance(String param1, String param2) {
        ServiceFragment fragment = new ServiceFragment();
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
        return inflater.inflate(R.layout.fragment_services, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        Animation topAnim = AnimationUtils.loadAnimation(getContext(), R.anim.fragment);
        RecyclerView servicesFeed = view.findViewById(R.id.services_feed);
        servicesFeed.setAnimation(topAnim);

        RecyclerView recyclerView = view.findViewById(R.id.services_feed);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);
        ServiceAdapter sAdapter = new ServiceAdapter(getContext(), ServicesPacks);
        recyclerView.setAdapter(sAdapter);
        sAdapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        ServicesPacks = new ArrayList<>();
        String[] Headers = new String[]{
                "Раздел 1",
                "Раздел 2",
                "Раздел 3",
                "Раздел 4",
        };

        for (String s: Headers) {
            Service service = new Service(s);
            ServicesPacks.add(service);
        }
    }
}