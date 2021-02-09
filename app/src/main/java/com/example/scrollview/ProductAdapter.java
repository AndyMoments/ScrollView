package com.example.scrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Restaurantes> restaurantesList;
    private Context context;

    public ProductAdapter(Context context, List<Restaurantes> restaurantesList) {
        this.context = context;
        this.restaurantesList = restaurantesList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_product , null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Restaurantes restaurantes = restaurantesList.get(position);
        Glide.with(context)
                .load(restaurantes.getImage())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.img_product);

        holder.tv_name.setText(restaurantes.getName());
        holder.tv_desc.setText(restaurantes.getDesc());
        holder.tv_price.setText(restaurantes.getPrice());

    }

    @Override
    public int getItemCount() {
        return restaurantesList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name, tv_desc, tv_price;
        ImageView img_add_to_cart, img_product;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_price = itemView.findViewById(R.id.tv_price);
            img_add_to_cart = itemView.findViewById(R.id.img_add_to_cart);
            img_product = itemView.findViewById(R.id.img_product);

        }
    }
}
