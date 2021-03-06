package com.example.hamrobook_ebookstore.Ui.Favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.adapter.FavoriteAdapter;
import com.example.hamrobook_ebookstore.api.FavoriteApi;
import com.example.hamrobook_ebookstore.model.Favorite;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteFragment extends Fragment {

    RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = root.findViewById(R.id.recyclerViewFavorite);
        getProduct();
        return root;
    }

    private void getProduct(){
        FavoriteApi favoriteApi= Url.getInstance().create(FavoriteApi.class);
        Call<List<Favorite>> listCall= favoriteApi.getFavorite(Url.token);
        listCall.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                FavoriteAdapter itemAdapter=new FavoriteAdapter(getActivity(),response.body());
                recyclerView.setAdapter(itemAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
                itemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}