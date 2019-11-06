package com.jatin.vjm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class appointment extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listitems;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        book=(Button)findViewById(R.id.book);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listitems=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            Listitem listitem=new Listitem(
              "dr."+"(SPECIALIZATION)"+(i+1),
              "Hospname"+(i*i)
            );
            listitems.add(listitem);

        }
        adapter=new MyAdapter(listitems,this);
        recyclerView.setAdapter(adapter);
    }
}
