package com.example.hamrobook_ebookstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Order;
import com.example.hamrobook_ebookstore.model.Product;

import org.w3c.dom.Text;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context context ;
    private List<Order> orderList ;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlayout,parent,false);
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Order order=orderList.get(position);
        holder.tvProductname.setText(order.getProductname());
        holder.tvPrice.setText(order.getRate());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductname,tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductname=itemView.findViewById(R.id.tvProductname);
            tvPrice=itemView.findViewById(R.id.tvPrice);
        }
    }
}
