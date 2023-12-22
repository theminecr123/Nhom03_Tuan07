package Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.squareup.picasso.Picasso;

import java.net.CookieHandler;
import java.util.List;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.tintucHolder> {
    List<Model_TinTuc> list;

    public TinTucAdapter(List<Model_TinTuc> list) {
        this.list = list;
    }

    @Override
    public tintucHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tintuc_layout, parent, false);
        return new tintucHolder(view);
    }

    @Override
    public void onBindViewHolder(tintucHolder holder, int position) {
        Model_TinTuc tinTuc = list.get(position);
        holder.tv_title.setText(tinTuc.getTitle());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        // Sử dụng thư viện như Glide hoặc Picasso để tải hình ảnh từ URL
        Glide.with(holder.imageview.getContext())
                .load("https://i.pinimg.com/736x/6e/74/63/6e7463744c9fdf25c505adfd51902f50.jpg")
                .apply(options)
                .into(holder.imageview);




        holder.tv_title.setOnClickListener(v -> {
            // Mở URL khi nhấn vào tiêu đề
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tinTuc.getArticleUrl()));
            holder.imageview.getContext().startActivity(browserIntent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class tintucHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView tv_title;

        public tintucHolder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

}