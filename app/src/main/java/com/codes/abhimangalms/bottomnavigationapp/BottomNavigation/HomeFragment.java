package com.codes.abhimangalms.bottomnavigationapp.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codes.abhimangalms.bottomnavigationapp.Product;
import com.codes.abhimangalms.bottomnavigationapp.ProductAdapter;
import com.codes.abhimangalms.bottomnavigationapp.R;
import com.codes.abhimangalms.bottomnavigationapp.NavigationDrawer.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        productList = new ArrayList<>();


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);//to make recyclerview a fixed size

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        productList.add(
                new Product(
                        1,
                        " Andy Rubin",
                        "22 oct at 9.38 pm",
                        "Android is a mobile operating system developed by Google, based on a modified version of the ",
                        R.drawable.macbook));

        productList.add(
                new Product(
                        1,
                        " Rich Miner",
                        "23 oct at 9.50 pm",
                        "Initially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007.",
                        R.drawable.pandaa));

        productList.add(
                new Product(
                        1,
                        " Nick Sears",
                        "24 oct at 10.38 pm",
                        "Android has been the best-selling OS worldwide on smartphones since 2011 and on tablets since 2013.",
                        R.drawable.pandaaa));

        productList.add(
                new Product(
                        1,
                        " Chris White",
                        "25 oct at 11.38 pm",
                        "The name Andrew and the noun Android share the Greek root andros, which means man. Andy Rubin .",
                        R.drawable.macbook));

        productList.add(
                new Product(
                        1,
                        " Andy Rubin",
                        "22 oct at 1.08 pm",
                        "Android is a mobile operating system developed by Google, based on a modified version of the ",
                        R.drawable.macbook));

        productList.add(
                new Product(
                        1,
                        " Rich Miner",
                        "23 oct at 8.28 pm",
                        "Initially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007",
                        R.drawable.pandaa));

        productList.add(
                new Product(
                        1,
                        " Nick Sears",
                        "24 oct at 9.58 pm",
                        "Android has been the best-selling OS worldwide on smartphones since 2011 and on tablets since 2013.",
                        R.drawable.pandaaa));

        productList.add(
                new Product(
                        1,
                        " Chris White",
                        "25 oct at 9.38 pm",
                        "The name Andrew and the noun Android share the Greek root andros, which means man. Andy Rubin .",
                        R.drawable.macbook));


        ProductAdapter.OnMyItemClickedInterface objInterface = new ProductAdapter.OnMyItemClickedInterface() {

            @Override
            public void myItemClicked(int selPosition) {
                Log.d("XXXX", "myItemClicked: position " + selPosition);


            }

            @Override
            public void myImageClicked(int selPosition) {

            }

            @Override
            public void myDescriptionClicked(int selposition) {

                Intent intent = new Intent(getContext(), FeedActivity.class);
                startActivity(intent);

            }
        };

        adapter = new ProductAdapter(getContext(), productList, objInterface);
        recyclerView.setAdapter(adapter);

        return view;

    }

}
