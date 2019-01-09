package com.example.qasim.whatsappclone.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qasim.whatsappclone.R;
import com.example.qasim.whatsappclone.SQLDatabaseAdapter;
import com.example.qasim.whatsappclone.adapter.ContactAdapter;
import com.example.qasim.whatsappclone.model.Person;

import java.util.List;

public class ChatFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Person> items;
    private SQLDatabaseAdapter dbAdapter;
    private ContactAdapter contactAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat,container,false);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbAdapter = new SQLDatabaseAdapter(this.getActivity());
        items = dbAdapter.getAllPersons();
        contactAdapter = new ContactAdapter(items, this.getActivity());
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
