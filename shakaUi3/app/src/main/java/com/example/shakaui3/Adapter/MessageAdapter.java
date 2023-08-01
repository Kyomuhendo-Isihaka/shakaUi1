package com.example.shakaui3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shakaui3.R;

public class MessageAdapter extends BaseAdapter {

    private Context context;

    private String senderName[];

    private String timeSent[];

    public MessageAdapter (Context context, String senderName[], String timeSent[]){
        this.context = context;
        this.senderName = senderName;
        this.timeSent = timeSent;
    }



    @Override
    public int getCount() {
        return senderName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView senderName, timeSent;
        View viewLayer_out = LayoutInflater.from(context).inflate(R.layout.item_message,null,false);

        senderName = viewLayer_out.findViewById(R.id.senderName);
        timeSent = viewLayer_out.findViewById(R.id.timeSent);

        senderName.setText(this.senderName[i]);
        timeSent.setText(this.timeSent[i]);

        return viewLayer_out;
    }
}
