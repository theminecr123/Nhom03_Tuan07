package Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nhom03_tuan07.R;
import java.net.CookieHandler;
import java.util.List;


public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.TinTucHolder> {
    List<Model_TinTuc> list;

    public TinTucAdapter(List<Model_TinTuc> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public TinTucHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tintuc_layout, parent, false);
        return new TinTucHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TinTucHolder holder, int position) {
        Model_TinTuc tinTuc = list.get(position);
        holder.tvTitle.setText(tinTuc.getTitle());
        holder.tvUrl.setText(tinTuc.getArticleUrl());
        Glide.with(holder.imageView.getContext())
                .load(tinTuc.getImageUrl())
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.baseline_error_24)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tinTuc.getArticleUrl()));
            holder.imageView.getContext().startActivity(browserIntent);
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addData(Model_TinTuc newTinTuc) {
        list.add(newTinTuc);
        notifyDataSetChanged();
        Log.d("TinTucAdapter", "Added new item: " + newTinTuc.getTitle());
    }
    public static class TinTucHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        TextView tvUrl;
        public TinTucHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvUrl = itemView.findViewById(R.id.eturlBaiViet);
        }
    }
}
