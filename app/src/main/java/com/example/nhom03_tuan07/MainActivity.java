package com.example.nhom03_tuan07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adapters.Model_TinTuc;
import Adapters.TinTucAdapter;


public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    List<Model_TinTuc> tintuclist;
    TinTucAdapter tintucadapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabAddNews = findViewById(R.id.fabAddNews);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tintuclist = new ArrayList<>();
        tintucadapter = new TinTucAdapter(tintuclist);
        recyclerView.setAdapter(tintucadapter);

        // Thêm dữ liệu ban đầu vào adapter
        tintucadapter.addData(new Model_TinTuc("https://news.khangz.com/wp-content/uploads/2023/12/Samsung-galaxy-s24-co-gi-moi-1.jpg", "Lãi suất huy động thấp lịch sử, 'cuộc đua' chưa có hồi kết", "https://viettelstore.vn/tin-tuc/samsung-galaxy-s24-co-gi-moi-2"));
        tintucadapter.addData(new Model_TinTuc("https://static-images.vnncdn.net/files/publish/2023/12/23/dsc-0144-917.jpg?width=0&s=KYu6PSaFlwtvUaIpbq_SFw", "Samsung Galaxy S24 có gì mới? Bao giờ ra mắt? Giá bán bao nhiêu?", "https://vietnamnet.vn/lai-suat-huy-dong-thap-lich-su-cuoc-dua-chua-co-hoi-ket-2230344.html"));
        // Thêm các mục tin tức khác nếu cần
        tintucadapter.notifyDataSetChanged();

        fabAddNews.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddNewsActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Model_TinTuc newTinTuc = (Model_TinTuc) data.getParcelableExtra("newTinTuc");
            if (newTinTuc != null) {
                if (tintucadapter != null) {
                    tintucadapter.addData(newTinTuc);
                    tintucadapter.notifyDataSetChanged();
                    Toast.makeText(this, "Thêm tin tức thành công", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}