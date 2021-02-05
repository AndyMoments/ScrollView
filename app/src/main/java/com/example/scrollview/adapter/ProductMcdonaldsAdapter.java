package com.example.scrollview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.scrollview.R;
import com.example.scrollview.model.ProductMcdonalds;
import com.example.scrollview.activity.SplashActivity;

import java.util.List;

public class ProductMcdonaldsAdapter extends RecyclerView.Adapter<ProductMcdonaldsAdapter.ProductMcdonaldsViewHolder>{

    private List<ProductMcdonalds> productMcdonaldsList;
    private Context context;
    private ImageButton img_add_to_cart;

    public ProductMcdonaldsAdapter(Context context, List<ProductMcdonalds> productMcdonaldsList) {
        this.context = context;
        this.productMcdonaldsList = productMcdonaldsList;
    }

    public ProductMcdonaldsAdapter(SplashActivity context, List<ProductMcdonalds> productMcdonaldList) {
    }

    @NonNull
    @Override
    public ProductMcdonaldsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_productmcdonalds , null);
        return new ProductMcdonaldsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductMcdonaldsViewHolder holder, int position) {

        ProductMcdonalds productMcdonalds = productMcdonaldsList.get(position);
        Glide.with(context)
                .load(productMcdonalds.getImage())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.img_product);

        holder.tv_name.setText(productMcdonalds.getName());
        holder.tv_desc.setText(productMcdonalds.getDesc());
        holder.tv_price.setText(productMcdonalds.getPrice());

    }

    @Override
    public int getItemCount() {
        return productMcdonaldsList.size();
    }

    public static class ProductMcdonaldsViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name, tv_desc, tv_price;
        ImageView img_add_to_cart, img_product;

        public ProductMcdonaldsViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_price = itemView.findViewById(R.id.tv_price);
            img_add_to_cart = itemView.findViewById(R.id.my_image_button);
            img_product = itemView.findViewById(R.id.img_product);

        }

    }

}
