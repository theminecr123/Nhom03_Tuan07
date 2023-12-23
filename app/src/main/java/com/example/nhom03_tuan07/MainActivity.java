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
import Adapters.Model_TinTuc;
import Adapters.TinTucAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    List<Model_TinTuc> tintuclist;
    TinTucAdapter tintucadapter;

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
        tintuclist.add(new Model_TinTuc("https://news.khangz.com/wp-content/uploads/2022/09/khung-vien-cua-nhung-phien-ban-iphone-14-duoc-lam-tu-titan-1-750x536.jpg", "Iphone 15 ra mắt", "https://vnexpress.net/israel-yeu-cau-dan-mien-trung-dai-gaza-so-tan-4692370.html"));
        tintuclist.add(new Model_TinTuc("https://i.pinimg.com/236x/f0/94/32/f094321d08607348b10173e76fd124ab.jpg", "Mấy con vịt", "https://vnexpress.net/israel-yeu-cau-dan-mien-trung-dai-gaza-so-tan-4692370.html"));
        fabAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewsActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                Model_TinTuc newTinTuc = (Model_TinTuc) data.getParcelableExtra("newTinTuc");
                if (newTinTuc != null) {
                    tintucadapter.addData(newTinTuc);
                    Toast.makeText(this, "Thêm tin tức thành công", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
