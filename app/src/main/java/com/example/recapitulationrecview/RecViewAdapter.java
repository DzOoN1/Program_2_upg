package com.example.recapitulationrecview;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    ArrayList<Book> books = new ArrayList<Book>();
    Context mContext;

    public RecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_book_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(books.get(position).getImageURL()).into(holder.image);
        holder.txtBookName.setText(books.get(position).getBookname());


        if(books.get(position).isExpanded()){
            holder.btnDownArrow.setVisibility(View.GONE);
            holder.expandedLayout.setVisibility(View.VISIBLE);
        }
        else{
            holder.btnDownArrow.setVisibility(View.VISIBLE);
            holder.expandedLayout.setVisibility(View.GONE);
        }
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtPages.setText(String.valueOf(books.get(position).getPages()));
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,BookActivity.class);
                intent.putExtra("ID",books.get(position).getID());
                mContext.startActivity(intent);

            }
        });
        if(books != DataBase.getAllBooks()){
            holder.btnTrash.setVisibility(View.VISIBLE);
            holder.btnTrash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(books == DataBase.getInstance().getReadBooks()){
                        if(books.get(position) != null){
                        DataBase.getInstance().removeFromReadList(books.get(position));
                        notifyDataSetChanged();}
                    }
                    if(books == DataBase.getInstance().getNotReadBooks()){
                        if(books.get(position) != null){
                        DataBase.getInstance().removeFromNotReadList(books.get(position));
                        notifyDataSetChanged();}
                    }


                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView parent;
        ImageView image;
        TextView txtBookName, txtAuthor, txtPages;
        ImageView btnUpArrow, btnDownArrow;
        RelativeLayout expandedLayout;
        ImageView btnTrash;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            parent = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.image);
            txtBookName = itemView.findViewById(R.id.txtBookName);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtPages = itemView.findViewById(R.id.txtPages);
            btnDownArrow = itemView.findViewById(R.id.btnDownArrow);
            btnUpArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);
            btnTrash = itemView.findViewById(R.id.btnTrash);


            btnDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    if(!book.isExpanded()){
                        book.setExpanded(true);
                        notifyItemChanged(getAdapterPosition());
                    }
                }
            });
            btnUpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    if(book.isExpanded()){
                        book.setExpanded(false);
                        notifyItemChanged(getAdapterPosition());
                    }
                }
            });


        }
    }
}
