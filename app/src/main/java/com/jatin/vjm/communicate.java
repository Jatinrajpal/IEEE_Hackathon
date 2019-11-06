package com.jatin.vjm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class communicate extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listitems;
    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listitems=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            Listitem listitem=new Listitem(
                    "dr."+(i+1),
                    "Hospname"+(i*i)
            );
            listitems.add(listitem);

        }
        adapter=new MyAdapter1(listitems,this);
        recyclerView.setAdapter(adapter);
    }
}
