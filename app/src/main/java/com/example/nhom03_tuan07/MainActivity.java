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
//        initSet();
//        tintuclisttt();
        FloatingActionButton fabAddNews = findViewById(R.id.fabAddNews);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<Model_TinTuc> tinTucs = new ArrayList<>();
        tinTucs.add(new Model_TinTuc("https://news.khangz.com/wp-content/uploads/2022/09/khung-vien-cua-nhung-phien-ban-iphone-14-duoc-lam-tu-titan-1-750x536.jpg", "Chẳng phải tự nhiên mà khi nhắc nhớ về một hành trình dài nào đó", "https://vnexpress.net/israel-yeu-cau-dan-mien-trung-dai-gaza-so-tan-4692370.html"));
        tinTucs.add(new Model_TinTuc("https://news.khangz.com/wp-content/uploads/2022/09/khung-vien-cua-nhung-phien-ban-iphone-14-duoc-lam-tu-titan-1-750x536.jpg", "Chẳng phải tự nhiên mà khi nhắc nhớ về một hành trình dài nào đó", "https://vnexpress.net/israel-yeu-cau-dan-mien-trung-dai-gaza-so-tan-4692370.html"));
        tinTucs.add(new Model_TinTuc("https://news.khangz.com/wp-content/uploads/2022/09/khung-vien-cua-nhung-phien-ban-iphone-14-duoc-lam-tu-titan-1-750x536.jpg", "ABC", "https://nld.com.vn/240-trieu-may-tinh-co-nguy-co-bien-thanh-cuc-gach-196231223105434981.htm"));
        TinTucAdapter adapter = new TinTucAdapter(tinTucs);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        fabAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện nhấn nút để thêm tin tức mới
                // Mở một activity mới để thêm tin tức
                //Intent intent = new Intent(MainActivity.this, AddNewsActivity.class);
                //startActivityForResult(intent, 1);


            }
        });



    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            // Xử lý dữ liệu trả về từ activity thêm tin tức
//            if (data != null) {
//                Model_TinTuc newTinTuc = (Model_TinTuc) data.getSerializableExtra("newTinTuc");
//                if (newTinTuc != null) {
//                    tintuclist.add(newTinTuc);
//                    tintucadapter.notifyDataSetChanged();
//                    Toast.makeText(this, "Thêm tin tức thành công", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }
}