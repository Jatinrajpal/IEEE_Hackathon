package com.jatin.vjm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

    private List<Listitem> Listitems;
    private Context context;

    public MyAdapter1(List<Listitem> listitems, Context context) {
        Listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item1,parent,false);
        return new MyAdapter1.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Listitem listitem=Listitems.get(position);
        holder.docname.setText(listitem.getDocname());
        holder.hospname.setText(listitem.getHospname());
        holder.Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,booked.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView docname;
        public TextView hospname;
        Button Book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            docname=(TextView)itemView.findViewById(R.id.docname1);
            hospname=(TextView)itemView.findViewById(R.id.hospname1);
            Book=(Button)itemView.findViewById(R.id.book1);

        }
    }


}
