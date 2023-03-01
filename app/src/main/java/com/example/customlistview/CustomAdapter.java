package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {

    private ArrayList<CountryModelClass> countryArrayList;
    Context context;

    public CustomAdapter(ArrayList<CountryModelClass> data, Context context) {
        super(context, R.layout.item_list_layout, data);
        this.countryArrayList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        CountryModelClass dataModel = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false);
            // Initialize the views
            viewHolder.tv_Country = (TextView) convertView.findViewById(R.id.tv_country_name);
            viewHolder.tv_wins = (TextView) convertView.findViewById(R.id.tv_win_title);
            viewHolder.iv_logo = (ImageView) convertView.findViewById(R.id.iv_logo);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        // Get the data from the model class
        viewHolder.tv_Country.setText(dataModel.getCountryName());
        viewHolder.tv_wins.setText(dataModel.getWinTitleCount());
        viewHolder.iv_logo.setImageResource(dataModel.getFlagImage());

        return convertView;

    }

    // View Lookup Cache (class)
    private static class ViewHolder {
        TextView tv_Country;
        TextView tv_wins;
        ImageView iv_logo;
    }
}
