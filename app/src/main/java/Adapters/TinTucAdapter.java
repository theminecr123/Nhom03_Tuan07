package Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nhom03_tuan07.R;
import com.example.nhom03_tuan07.WebViewActivity;

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




        // Sử dụng thư viện như Glide hoặc Picasso để tải hình ảnh từ URL
        Glide.with(holder.imageview.getContext())
                .load(tinTuc.getImageUrl())
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.baseline_error_24)
                .into(holder.imageview);




        holder.tv_title.setOnClickListener(v -> {
            // Mở URL khi nhấn vào tiêu đề
            /*Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tinTuc.getArticleUrl()));
            holder.imageview.getContext().startActivity(browserIntent);*/
            Intent intent = new Intent(v.getContext(), WebViewActivity.class);
            intent.putExtra("link", tinTuc.getArticleUrl());
            v.getContext().startActivity(intent);
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