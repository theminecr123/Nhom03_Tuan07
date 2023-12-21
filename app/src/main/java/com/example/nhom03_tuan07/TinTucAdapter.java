package com.example.nhom03_tuan07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.ViewHolder> {
    private Context context;
    private List<Model_TinTuc> tintucList;

    public TinTucAdapter(Context context, List<Model_TinTuc> tintucList) {
        this.context = context;
        this.tintucList = tintucList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tintuc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model_TinTuc tinTuc = tintucList.get(position);

        // Sử dụng Glide để tải hình ảnh từ URL vào ImageView
        Glide.with(context)
                .load(tinTuc.getImageUrl())
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.baseline_error_24)
                .into(holder.imageView);

        holder.titleTextView.setText(tinTuc.getTitle());
        holder.descriptionTextView.setText(tinTuc.getDescription());
    }
    @Override
    public int getItemCount() {
        return tintucList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);


        }
    }
}
