package com.example.hamrobook_ebookstore.Admin.latest;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.adapter.AllAdapter;
import com.example.hamrobook_ebookstore.adapter.LatestRecyclerAdapter;
import com.example.hamrobook_ebookstore.api.ProductApi;
import com.example.hamrobook_ebookstore.model.Book;
import com.example.hamrobook_ebookstore.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LatestFragment extends Fragment {

    RecyclerView recyclerView;
    public LatestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_latest, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewLatest);
        getProduct();
        return root;
    }
    private void getProduct(){
        ProductApi productApi= Url.getInstance().create(ProductApi.class);
        Call<List<Product>> listCall= productApi.getProduct();
        listCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                LatestRecyclerAdapter itemAdapter=new LatestRecyclerAdapter(getActivity(),response.body());
                recyclerView.setAdapter(itemAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
                itemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
