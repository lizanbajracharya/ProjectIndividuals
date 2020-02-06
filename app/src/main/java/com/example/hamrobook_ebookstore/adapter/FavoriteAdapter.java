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
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.DisplayActivity;
import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {
    private Context context;
    private List<Product> productList;

    public FavoriteAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.cardveiw_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Product item=productList.get(position);
        holder.tv_book_title.setText(item.getProductName());
        Picasso.get().load(Url.base_url_image+productList.get(position).getProductImage()).into(holder.img_book_thumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayActivity.class);
                // passing data to the book activity
                intent.putExtra("Title",productList.get(position).getProductName());
                intent.putExtra("Description",productList.get(position).getProductDescription());
                intent.putExtra("Thumbnail",productList.get(position).getProductImage());
                intent.putExtra("Price",productList.get(position).getPrice());
                intent.putExtra("Writer",productList.get(position).getWriter());
                intent.putExtra("Stock",productList.get(position).getStock());
                // start the activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_book_title =  itemView.findViewById(R.id.book_title_id) ;
            img_book_thumbnail =  itemView.findViewById(R.id.book_img_id);
            cardView =  itemView.findViewById(R.id.cardview_id);
        }
    }
}
