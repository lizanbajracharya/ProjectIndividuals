package com.example.hamrobook_ebookstore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.BookActivity;
import com.example.hamrobook_ebookstore.DisplayActivity;
import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.model.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context context;
    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Book item=bookList.get(position);
        holder.tvBookName.setText(item.getBookName());
        holder.tvCategory.setText(item.getCategory());
        holder.tvWriter.setText(item.getBookWriter());
        holder.constraintlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayActivity.class);
                // passing data to the book activity
                intent.putExtra("id",bookList.get(position).getId());
               intent.putExtra("BookName",bookList.get(position).getBookName());
               intent.putExtra("Category",bookList.get(position).getCategory());
               intent.putExtra("Writer",bookList.get(position).getBookWriter());
               intent.putExtra("BookContent",bookList.get(position).getBookContent());
                // start the activity
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvBookName,tvWriter,tvCategory;
       ConstraintLayout constraintlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBookName =  itemView.findViewById(R.id.tvBookname) ;
            tvCategory =  itemView.findViewById(R.id.tvCategory);
            tvWriter =  itemView.findViewById(R.id.tvWriter);
            constraintlayout=itemView.findViewById(R.id.contraintlayout);
        }
    }
}
