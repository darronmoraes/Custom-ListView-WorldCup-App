package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 - AdapterView : a listView
        listView = findViewById(R.id.listview);

        // 2 - Data Source
        dataModel = new ArrayList<>();
        dataModel.add(new CountryModelClass("Argentina", "3", R.drawable.argentina));
        dataModel.add(new CountryModelClass("South Africa", "0", R.drawable.south_africa));
        dataModel.add(new CountryModelClass("Brazil", "5", R.drawable.brazil));
        dataModel.add(new CountryModelClass("England", "1", R.drawable.england));
        dataModel.add(new CountryModelClass("India", "0", R.drawable.india));
        dataModel.add(new CountryModelClass("Qatar", "0", R.drawable.qatar));
        dataModel.add(new CountryModelClass("Spain", "1", R.drawable.spain));
        dataModel.add(new CountryModelClass("USA", "0", R.drawable.usa));

        // 3 - Adapter
        adapter = new CustomAdapter(dataModel, getApplicationContext());

        listView.setAdapter(adapter);

        // 4 - Handling onClick events on ListView Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        adapter.getItem(position).getCountryName() +
                        " Won " + adapter.getItem(position).getWinTitleCount() + " titles",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}