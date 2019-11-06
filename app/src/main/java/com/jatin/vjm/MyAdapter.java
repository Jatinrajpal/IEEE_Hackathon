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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Listitem> Listitems;
    private Context context;

    public MyAdapter(List<Listitem> listitems, Context context) {
        Listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
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
            docname=(TextView)itemView.findViewById(R.id.docname);
            hospname=(TextView)itemView.findViewById(R.id.hospname);
            Book=(Button)itemView.findViewById(R.id.book);

        }
    }


}
