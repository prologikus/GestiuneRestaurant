package com.example.meg3o.gestiunerestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class acasa extends AppCompatActivity implements mainListAdapter.ItemClickListener {
    RecyclerView incoming_recycler;
    mainListAdapter mainListAdapter;
    ConstraintLayout container;
    ConstraintLayout statusBar;
    MaterialButton newOrders;
    MapView mapView;
    Button oldOrders;
    GoogleMap googleMap;

    Integer listType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acasa);

        //register objects
        container = findViewById(R.id.container);
        statusBar = findViewById(R.id.statusBar);
        newOrders = findViewById(R.id.newOrders);
        oldOrders = findViewById(R.id.oldOrders);
        mapView = findViewById(R.id.mapView);


        newOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listType != 1) {
                    newOrders.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                    oldOrders.getBackground().setColorFilter(getResources().getColor(R.color.AppBarButton), PorterDuff.Mode.MULTIPLY);
                    listType = 1;
                    showList(1);
                }
            }
        });

        oldOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listType != 0) {
                    oldOrders.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
                    newOrders.getBackground().setColorFilter(getResources().getColor(R.color.AppBarButton), PorterDuff.Mode.MULTIPLY);
                    listType = 0;
                    showList(0);
                }
            }
        });

        //set default LIST TYPE
        newOrders.performClick();

        container.setVisibility(View.GONE);

        statusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                container.setVisibility(View.GONE);
            }
        });

        //creating a fake list
        List<orderList> incoming_list = new ArrayList<>();
        orderList user1 = new orderList("George Oprea");
        orderList user2 = new orderList("Cristi Grozea");
        orderList user3 = new orderList("Marian");
        incoming_list.add(user1);
        incoming_list.add(user2);
        incoming_list.add(user3);

        //register recycler
        incoming_recycler = findViewById(R.id.incoming_recycler);
        incoming_recycler.setLayoutManager(new LinearLayoutManager(this));
        mainListAdapter = new mainListAdapter(this, incoming_list);
        mainListAdapter.setClickListener(this);
        incoming_recycler.setAdapter(mainListAdapter);
    }

    public void showList(Integer type) {
        container.setVisibility(View.GONE);
    }

    //On (main list) item click
    @Override
    public void onItemClick(View view, int position) {
        container.setVisibility(View.VISIBLE);

    }
}
