package com.example.mailapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.mailapp.R;
import com.example.mailapp.adapters.MailAdapter;
import com.example.mailapp.models.Mail;

import java.util.List;


public class ListFragment extends Fragment {

    private ListView listView;
    private List<Mail> mails;
    private MailAdapter adapter;


    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        listView = view.findViewById(R.id.listViewMails);
        //completar declaracion de mails -> Util
        adapter = new MailAdapter(getContext(),R.layout.list_view_mail,mails); //completar
        listView.setAdapter((ListAdapter) adapter);
        //completar



    }
}