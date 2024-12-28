package com.example.quizdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FolderAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] folders;

    public FolderAdapter(Context context, String[] folders) {
        super(context, R.layout.list_item_folder, folders);
        this.context = context;
        this.folders = folders;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_folder, parent, false);
        }

        // Gán dữ liệu vào TextView
        TextView textViewFolder = convertView.findViewById(R.id.textViewFolderName);
        textViewFolder.setText(folders[position]);

        return convertView;
    }
}
