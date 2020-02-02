package com.example.hamrobook_ebookstore.Admin.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrobook_ebookstore.R;
import com.example.hamrobook_ebookstore.adapter.LatestRecyclerAdapter;
import com.example.hamrobook_ebookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {

    List<Book> lstBook ;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_book, container, false);
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

        RecyclerView myrv = root.findViewById(R.id.recyclerViewBook);
        LatestRecyclerAdapter myAdapter = new LatestRecyclerAdapter(getActivity(),lstBook);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        myrv.setAdapter(myAdapter);
        return root;
    }
}