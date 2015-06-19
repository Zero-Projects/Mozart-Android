package com.mozart.custom_view_volley;
// This class takes care of caching images on disk.
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mozart.mozart_android.R;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<WorkModel> workItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<WorkModel> workItems) {
        this.activity = activity;
        this.workItems = workItems;
    }

    @Override
    public int getCount() {
        return workItems.size();
    }

    @Override
    public Object getItem(int location) {
        return workItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.activity_explore_works, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView networkImageView = (NetworkImageView) convertView.findViewById(R.id.cover);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView autor = (TextView) convertView.findViewById(R.id.autor);
        TextView category = (TextView) convertView.findViewById(R.id.category);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        // getting work data for the row
        WorkModel workModel = workItems.get(position);

        // cover image
        networkImageView.setImageUrl(workModel.getCoverURL(), imageLoader);

        // title
        title.setText(workModel.getTitle());

        // autor
        autor.setText("Autor: " + String.valueOf(workModel.getAutor()));

        // category
        category.setText("Categoria: "+String.valueOf(workModel.getCategory()));

        // date
        date.setText(String.valueOf(workModel.getDate()));

        return convertView;
    }

}