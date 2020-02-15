package com.example.hamrobook_ebookstore.Ui.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.Url.Url;
import com.example.hamrobook_ebookstore.adapter.BannerAdapter;
import com.example.hamrobook_ebookstore.adapter.CategoryAdapter;
import com.example.hamrobook_ebookstore.adapter.LatestRecyclerAdapter;
import com.example.hamrobook_ebookstore.api.CategoryApi;
import com.example.hamrobook_ebookstore.api.ProductApi;
import com.example.hamrobook_ebookstore.model.Category;
import com.example.hamrobook_ebookstore.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {

    ViewPager viewPage;
    RecyclerView recyclerView,recyclerViewCategory;

    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_all, container, false);
        viewPage = root.findViewById(R.id.viewPage);
        BannerAdapter viewPagerAdapter = new BannerAdapter(getActivity());
        viewPage.setAdapter(viewPagerAdapter);
        recyclerView = root.findViewById(R.id.recyclerViewAll);
        recyclerViewCategory=root.findViewById(R.id.recyclerViewCategory);
        getCategory();
        getProduct();
        return root;
    }

    public void getCategory(){
        CategoryApi categoryApi = Url.getInstance().create(CategoryApi.class);
        Call<List<Category>> listCall =categoryApi.getCategory();
        listCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Toast" + response.code(), Toast.LENGTH_SHORT).show();
                }
                CategoryAdapter categoryAdapter =new CategoryAdapter(getActivity(),response.body());
                recyclerViewCategory.setAdapter(categoryAdapter);
                LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewCategory.setLayoutManager(layoutManager);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
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
