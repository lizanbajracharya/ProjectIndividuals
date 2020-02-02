package com.example.hamrobook_ebookstore.Admin.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.adapter.BannerAdapter;
import com.example.hamrobook_ebookstore.adapter.LatestRecyclerAdapter;
import com.example.hamrobook_ebookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {

    ViewPager viewPage;
    RecyclerView recyclerView;
    List<Book> lstBook ;
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

        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Vegitarian","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Wild Robot","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("Maria Semples","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("The Martian","Categorie Book","Description book",R.drawable.background_01));
        lstBook.add(new Book("He Died with...","Categorie Book","Description book",R.drawable.background_01));

        RecyclerView myrv = root.findViewById(R.id.recyclerViewAll);
        LatestRecyclerAdapter myAdapter = new LatestRecyclerAdapter(getActivity(),lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        myrv.setAdapter(myAdapter);
        return root;
    }

}
