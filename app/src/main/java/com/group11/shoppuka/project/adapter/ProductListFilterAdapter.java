package com.group11.shoppuka.project.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group11.shoppuka.R;
import com.group11.shoppuka.project.model.Product;

import java.util.List;

import kotlin.sequences.Sequence;

public class ProductListFilterAdapter extends RecyclerView.Adapter<ProductListFilterAdapter.Holder> {
    List<Product> listProduct;
    String s;

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(String s) {
        this.s = s;
        notifyDataSetChanged();
    }
    public ProductListFilterAdapter(List<Product> listProduct){
        this.listProduct = listProduct;

    }

    public void setProducts(List<Product> listProductFilter){
        this.listProduct = listProductFilter;
        for (Product product :this.listProduct){
            System.out.println(product.getName());
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.imageView.setImageResource(listProduct.get(position).getImage());
            holder.textView.setText(listProduct.get(position).getName());
            holder.textView1.setText(listProduct.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView1;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewProduct);
            textView = itemView.findViewById(R.id.textViewNameProduct);
            textView1 = itemView.findViewById(R.id.textViewPriceProduct);
        }
    }
}
