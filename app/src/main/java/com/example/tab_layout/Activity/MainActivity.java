package com.example.tab_layout.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tab_layout.R;
import com.example.tab_layout.Adapter.recycle_adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<String> imagearr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        String image[];
        try {
            image=getAssets().list("image");
            imagearr=new ArrayList<String>(Arrays.asList(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        recycle_adapter adapter=new recycle_adapter(this,imagearr);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}