package com.example.hamrobook_ebookstore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.DashboardActivity;
import com.example.hamrobook_ebookstore.DisplayActivity;
import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.api.FavoriteApi;
import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Favorite;
import com.example.hamrobook_ebookstore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {
    private Context context;
    private List<Favorite> bookList;

    public FavoriteAdapter(Context context, List<Favorite> booklist) {
        this.context = context;
        this.bookList = booklist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Favorite item=bookList.get(position);
        holder.tvIDD.setText(item.getBook().getBookId());
        holder.tvBookName.setText(item.getBook().getBookName());
        holder.tvCategory.setText(item.getBook().getCategory());
        holder.tvWriter.setText(item.getBook().getBookWriter());
        holder.constraintlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayActivity.class);
                // passing data to the book activity
                intent.putExtra("id",bookList.get(position).getBook().getBookId());
                intent.putExtra("BookName",bookList.get(position).getBook().getBookName());
                intent.putExtra("Category",bookList.get(position).getBook().getCategory());
                intent.putExtra("Writer",bookList.get(position).getBook().getBookWriter());
                intent.putExtra("BookContent",bookList.get(position).getBook().getBookContent());
                // start the activity
                context.startActivity(intent);
            }
        });
        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoriteApi favoriteApi=Url.getInstance().create(FavoriteApi.class);
                Call<Void> voidCall=favoriteApi.removeFavorite(bookList.get(position).getId());
                voidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(context, "You have remove a favorite book", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context,DashboardActivity.class);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(context, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvBookName,tvWriter,tvCategory,tvIDD;
        ImageButton imgRemove;
        ConstraintLayout constraintlayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBookName =  itemView.findViewById(R.id.tvBook) ;
            tvCategory =  itemView.findViewById(R.id.tvCat);
            tvWriter =  itemView.findViewById(R.id.tvWrite);
            imgRemove=itemView.findViewById(R.id.imgRemove);
            tvIDD=itemView.findViewById(R.id.tvIDD);
            constraintlayout=itemView.findViewById(R.id.contraintlayoutFavorite);
        }
    }

}
