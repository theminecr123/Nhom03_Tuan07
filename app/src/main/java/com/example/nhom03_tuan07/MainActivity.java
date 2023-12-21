package com.example.nhom03_tuan07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    List<Model_TinTuc> tintuclist;
    TinTucAdapter tintucadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSet();
        tintuclisttt();
        FloatingActionButton fabAddNews = findViewById(R.id.fabAddNews);
        fabAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý sự kiện nhấn nút để thêm tin tức mới
                // Mở một activity mới để thêm tin tức
                Intent intent = new Intent(MainActivity.this, AddNewsActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void initSet() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
    }

    private void tintuclisttt() {

        tintuclist = new ArrayList<>();

        Model_TinTuc modelTinTuc1 = new Model_TinTuc(R.drawable.baseline_downloading_24,  "Chẳng phải tự nhiên mà khi nhắc nhớ về một hành trình dài nào đó", "HUTECH - Hành trình 25 năm","");
        Model_TinTuc modelTinTuc2 = new Model_TinTuc(R.drawable.baseline_downloading_24,  "HUTECH xếp thứ 8 trong BXH uniRank 2019","HUTECH - VỀ CHIỀU","");
        Model_TinTuc modelTinTuc3 = new Model_TinTuc(R.drawable.baseline_downloading_24, "24/9 vừa qua, sau quãng thời gian dài học tập và rèn luyện", "LỄ TỐT NGHIỆP TÂN CỬ NHÂN","");
        Model_TinTuc modelTinTuc4 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        Model_TinTuc modelTinTuc5 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        Model_TinTuc modelTinTuc6 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        Model_TinTuc modelTinTuc7 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        Model_TinTuc modelTinTuc8 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        Model_TinTuc modelTinTuc9 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        Model_TinTuc modelTinTuc10 = new Model_TinTuc(R.drawable.baseline_downloading_24, "đổi cách xét tuyển lớp 10", "Ba tỉnh thông báo bỏ bài thi tổ hợp","");
        tintuclist.add(modelTinTuc1);
        tintuclist.add(modelTinTuc2);
        tintuclist.add(modelTinTuc3);
        tintuclist.add(modelTinTuc4);
        tintuclist.add(modelTinTuc5);
        tintuclist.add(modelTinTuc6);
        tintuclist.add(modelTinTuc7);
        tintuclist.add(modelTinTuc8);
        tintuclist.add(modelTinTuc9);
        tintuclist.add(modelTinTuc10);


        tintucadapter = new TinTucAdapter(this, tintuclist);
        recyclerView.setAdapter(tintucadapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Xử lý dữ liệu trả về từ activity thêm tin tức
            if (data != null) {
                Model_TinTuc newTinTuc = (Model_TinTuc) data.getSerializableExtra("newTinTuc");
                if (newTinTuc != null) {
                    tintuclist.add(newTinTuc);
                    tintucadapter.notifyDataSetChanged();
                    Toast.makeText(this, "Thêm tin tức thành công", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}