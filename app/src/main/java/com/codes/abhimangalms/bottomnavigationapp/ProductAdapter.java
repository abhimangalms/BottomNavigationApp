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
import android.widget.Toast;

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
    private RecyclerViewClickedInterface listener;


    public static final String TAG = "ProductAdapter";

    //Interface for data transfer in RecyclerView
    public interface RecyclerViewClickedInterface {

        void recyclerDateClicked(int selPosition);
        void recyclerImageClicked(int selPosition);
        void recyclerDescriptionClicked(String descriptionContent, String imageUrlContent, String titleNameContent);

    }

    public ProductAdapter(Context mCtx, List<Product> productList, RecyclerViewClickedInterface listener) {
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
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {

        final Product product = productList.get(position);


        holder.mtextViewName.setText(product.getTitle());
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
                listener.recyclerDateClicked(position);

                Toast.makeText(mCtx, "clicked date", Toast.LENGTH_SHORT).show();
            }
        });


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.recyclerImageClicked(position);

                Toast.makeText(mCtx, "Image clicked", Toast.LENGTH_SHORT).show();
            }
        });

        holder.textViewDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String descriptionData = holder.textViewDescription.getText().toString(); //getting description
                String imageUrlData = product.getImageUrl(); //getting image url for the corresponding recyclerview
                String titleName = product.getTitle(); // getting title from recyclerView

                listener.recyclerDescriptionClicked(descriptionData, imageUrlData, titleName); //passing data to HomeFragment

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() { //
            @Override
            public void onClick(View v) {

                String descriptionData = holder.textViewDescription.getText().toString(); //getting description
                String imageUrlData = product.getImageUrl(); //getting image url for the corresponding recyclerview
                String titleName = product.getTitle(); // getting title from recyclerView

                listener.recyclerDescriptionClicked(descriptionData, imageUrlData, titleName); //passing data to HomeFragment

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView mtextViewName, textViewDate, textViewDescription;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            mtextViewName = itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imgView);

        }

    }

}
