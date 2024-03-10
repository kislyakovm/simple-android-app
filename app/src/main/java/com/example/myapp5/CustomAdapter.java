package com.example.myapp5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private List<String> contactNames;
    private List<String> contactBio;
    private Context context;

    public CustomAdapter(Context context, List<String> names, List<String> bios) {
        super(context, R.layout.item_samsung, names);
        this.context = context;
        this.contactNames = names;
        this.contactBio = bios;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_samsung, parent, false);

        TextView nameTextView = itemView.findViewById(R.id.user_name);
        TextView bioTextView = itemView.findViewById(R.id.user_bio);

        nameTextView.setText(contactNames.get(position));
        bioTextView.setText(contactBio.get(position));

        return itemView;
    }
}
