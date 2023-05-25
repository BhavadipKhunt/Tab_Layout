package com.example.tab_layout.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.tab_layout.Adapter.pager_adapter;
import com.example.tab_layout.Frafments.Info;
import com.example.tab_layout.Frafments.Menu;
import com.example.tab_layout.Frafments.Photos;
import com.example.tab_layout.R;
import com.google.android.material.tabs.TabLayout;


public class Category extends AppCompatActivity {
    TabLayout tableLayout;
    ViewPager viewPager;
    int position;
    String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        viewPager=findViewById(R.id.View_pager);
        tableLayout=findViewById(R.id.Tab_layout);
        image=getIntent().getStringExtra("image");
        position=getIntent().getIntExtra("position",0);
        pager_adapter pager_adapter=new pager_adapter(this,getSupportFragmentManager());
        viewPager.setAdapter(pager_adapter);
        pager_adapter.addfragment(new Info(position,image),"Info");
        pager_adapter.addfragment(new Photos(position),"Photo");

        pager_adapter.addfragment(new Menu(position),"Menu");
        tableLayout.setupWithViewPager(viewPager);

    }
}