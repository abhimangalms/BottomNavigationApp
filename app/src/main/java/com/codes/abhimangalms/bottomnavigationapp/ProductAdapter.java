package com.codes.abhimangalms.bottomnavigationapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.List;

/** created by Abhimangal on 28/10/2018*/

/*
* We need 2 things for RecyclerView
* RecyclerView.Adapter
* RecyclerView.ViewHolder
* */


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

     private Context mCtx;
     private List<Product> productList;
    private OnMyItemClickedInterface listener;


    public static final String TAG = "ProductAdapter";


    public interface OnMyItemClickedInterface {

        void myItemClicked(int selPosition);
        void myImageClicked(int selPosition);
        void myDescriptionClicked(int selposition);

    }


    public ProductAdapter(Context mCtx, List<Product> productList, OnMyItemClickedInterface listener) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout,null);
        ProductViewHolder holder = new ProductViewHolder(view);

        Log.i(TAG, "oncreate " + position);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {

        Product product = productList.get(position);


        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDescription.setText(String.valueOf(product.getShortdesc()));
        holder.textViewDate.setText(product.getDate());
      //  holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        //to load images from URL we use PICASSO library

        Picasso.get().
                load(product.getImageUrl()).
                placeholder(R.drawable.pandaa).
                into(holder.imageView);


        //item click listener for RecyclerView using interface

        holder.textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.myItemClicked(position);
            }
        });


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.myImageClicked(position);
            }
        });

        holder.textViewDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.myDescriptionClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textViewTitle, textViewDate, textViewDescription;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = (ImageView) itemView.findViewById(R.id.imgView);
        }


    }

}
