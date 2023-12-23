package com.example.nhom03_tuan07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WatchActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        listView = findViewById(R.id.list_view);

        // Thêm các item cho ListView
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[]{
                "https://thanhnien.vn/hp-sap-ra-mat-laptop-choi-game-14-inch-nhe-nhat-the-gioi-185231220015414914.htm",
                "https://thanhnien.vn/doc-dao-nhung-cay-thong-noel-an-duoc-185231222161316021.htm",
                "https://nld.com.vn/240-trieu-may-tinh-co-nguy-co-bien-thanh-cuc-gach-196231223105434981.htm",
                "https://nld.com.vn/khong-khi-lanh-khien-nhieu-tinh-thanh-ret-duoi-10-do-c-196231223084823433.htm"
        }));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String link = listView.getItemAtPosition(position).toString();
                Intent intent = new Intent(WatchActivity.this, WebViewActivity.class);
                intent.putExtra("link", link);
                startActivity(intent);
            }
        });


    }
}