package com.example.tab_layout.Adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tab_layout.Activity.Category;
import com.example.tab_layout.Activity.MainActivity;
import com.example.tab_layout.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class recycle_adapter extends RecyclerView.Adapter<recycle_adapter.User_holder> {
    MainActivity mainActivity;
    ArrayList<String> imagearr;

    public recycle_adapter(MainActivity mainActivity, ArrayList<String> imagearr) {
        this.imagearr=imagearr;
        this.mainActivity=mainActivity;
    }

    @NonNull
    @Override
    public recycle_adapter.User_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recycle_iteam,parent,false);
        User_holder userHolder=new User_holder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycle_adapter.User_holder holder, int position)
    {
        InputStream stream=null;
        try {
            stream=mainActivity.getAssets().open("image/"+imagearr.get(position));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable=Drawable.createFromStream(stream,null);
        holder.imageView.setImageDrawable(drawable);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mainActivity, Category.class);
                intent.putExtra("position",holder.getAdapterPosition());
                intent.putExtra("image",imagearr.get(holder.getAdapterPosition()));
                mainActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return imagearr.size();
    }

    public class User_holder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public User_holder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.Main_image);

        }
    }
}
