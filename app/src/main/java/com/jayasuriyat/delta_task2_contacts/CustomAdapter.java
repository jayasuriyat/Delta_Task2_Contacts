package com.jayasuriyat.delta_task2_contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


class CustomAdapter extends ArrayAdapter<String>
{
    public int[] c;
    CustomAdapter(Context context, String[] UtdPlayer,int[] img)
    {
        super(context,R.layout.custom_row, UtdPlayer);
        c=img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater JsInflater= LayoutInflater.from(getContext());
        View customView= JsInflater.inflate(R.layout.custom_row,parent,false);

        int images;
        images=c[position];

        String singlePlayer= getItem(position);
        TextView JTextView = (TextView) customView.findViewById(R.id.JTextView);
        ImageView JImageView= (ImageView) customView.findViewById(R.id.imageView);

        JTextView.setText(singlePlayer);
        JImageView.setImageResource(images);
        return customView;
    }
}
