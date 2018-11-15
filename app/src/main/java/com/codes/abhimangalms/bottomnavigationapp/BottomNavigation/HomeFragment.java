package com.codes.abhimangalms.bottomnavigationapp.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
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
                        "https://www.simplifiedcoding.net/demos/marvel/ironman.jpg"));

        productList.add(
                new Product(
                        1,
                        " Rich Miner",
                        "23 oct at 9.50 pm",
                        "Initially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007.",
                        "https://www.simplifiedcoding.net/demos/marvel/captainamerica.jpg"));

        productList.add(
                new Product(
                        1,
                        " Nick Sears",
                        "24 oct at 10.38 pm",
                        "Android has been the best-selling OS worldwide on smartphones since 2011 and on tablets since 2013.",
                        "https://www.simplifiedcoding.net/demos/marvel/logan.jpg"));

        productList.add(
                new Product(
                        1,
                        " Chris White",
                        "25 oct at 11.38 pm",
                        "The name Andrew and the noun Android share the Greek root andros, which means man. Andy Rubin .",
                        "https://www.simplifiedcoding.net/demos/marvel/spiderman.jpg"));

        productList.add(
                new Product(
                        1,
                        " Andy Rubin",
                        "22 oct at 9.38 pm",
                        "Android is a mobile operating system developed by Google, based on a modified version of the ",
                        "https://www.simplifiedcoding.net/demos/marvel/ironman.jpg"));

        productList.add(
                new Product(
                        1,
                        " Rich Miner",
                        "23 oct at 9.50 pm",
                        "Initially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007.",
                        "https://www.simplifiedcoding.net/demos/marvel/captainamerica.jpg"));

        productList.add(
                new Product(
                        1,
                        " Nick Sears",
                        "24 oct at 10.38 pm",
                        "Android has been the best-selling OS worldwide on smartphones since 2011 and on tablets since 2013.",
                        "https://www.simplifiedcoding.net/demos/marvel/logan.jpg"));

        productList.add(
                new Product(
                        1,
                        " Chris White",
                        "25 oct at 11.38 pm",
                        "The name Andrew and the noun Android share the Greek root andros, which means man. Andy Rubin .",
                        "https://www.simplifiedcoding.net/demos/marvel/spiderman.jpg"));


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {


            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });




        ProductAdapter.RecyclerViewClickedInterface objInterface = new ProductAdapter.RecyclerViewClickedInterface() {


            @Override
            public void recyclerDateClicked(int selPosition) {

            }

            @Override
            public void recyclerImageClicked(int selPosition) {

            }

            @Override
            public void recyclerDescriptionClicked(String descriptionContent, String imageUrlContent, String titleNameContent) {

                Intent intent = new Intent(getContext(), FeedActivity.class);
                intent.putExtra("descriptionFromHomeFragment", descriptionContent); //passing description data to FeedActivity
                intent.putExtra("imageUrlFromHomeFragment", imageUrlContent); //passing imageUrl to feedsActivity
                intent.putExtra("titleNameFromHomeFragment", titleNameContent); //passing imageUrl to feedsActivity


                startActivity(intent);

            }
        };

        adapter = new ProductAdapter(getContext(), productList, objInterface);
        recyclerView.setAdapter(adapter);

        return view;

    }

}
