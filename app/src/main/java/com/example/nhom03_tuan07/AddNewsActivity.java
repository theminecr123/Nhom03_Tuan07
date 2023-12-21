package com.example.nhom03_tuan07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewsActivity extends AppCompatActivity {

    private EditText etImageUrl, etTitle, etDescription;
    private Button btnAddNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        etImageUrl = findViewById(R.id.etImageUrl);
        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        btnAddNews = findViewById(R.id.btnAddNews);
        btnAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNews();
            }
        });
    }
    private void addNews() {
        String imageUrl = etImageUrl.getText().toString().trim();
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        if (imageUrl.isEmpty() || title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }
        Model_TinTuc newTinTuc = new Model_TinTuc(0, title, description, imageUrl);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("newTinTuc", newTinTuc);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}