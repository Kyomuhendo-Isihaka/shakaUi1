package com.example.shakaui3.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.shakaui3.Adapter.MessageAdapter;
import com.example.shakaui3.R;
public class MessageFragment extends Fragment {

    private MessageAdapter messageAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {;

        View view = inflater.inflate(R.layout.fragment_message, container, false);

        ListView messageListView = view.findViewById(R.id.messageListView);
        String senderName[] ={"Isihaka","Joan","Juliet","Edson","Davis"};
        String timeSent[]={"8:00pm", "3:34pm","2:03am","3:40am","@:00pm"};
        messageAdapter = new MessageAdapter(getContext(), senderName,timeSent);

        messageListView.setAdapter(messageAdapter);


        return view;
    }
}